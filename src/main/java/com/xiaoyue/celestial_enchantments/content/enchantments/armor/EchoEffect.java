package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.client.ClientEffectHandlers;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.l2library.capability.conditionals.*;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EchoEffect extends DefenceEnch implements TokenProvider<EchoEffect.Token, EchoEffect>, Context {

	private static final TokenKey<Token> KEY = TokenKey.of(CelestialEnchantments.loc("echo"));
	
	private static double heal() {
		return CEModConfig.COMMON.ench.armor.echoEffectHeal.get();
	}

	private static int cd() {
		return CEModConfig.COMMON.ench.armor.echoEffectCooldown.get();
	}

	public EchoEffect() {
		super(Rarity.VERY_RARE, Type.LEGS, EnchData.specialHigh(3, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (user instanceof ServerPlayer player) {
			cache.addDealtModifier(DamageModifier.nonlinearFinal(1010, v -> {
				if (v < user.getHealth()) return v;
				var data = ConditionalData.HOLDER.get(player);
				if (data.hasData(KEY)) return v;
				player.heal(player.getMaxHealth() * v * (float) heal());
				var token = data.getOrCreateData(this, this);
				token.timer = cd() * 20;
				token.sync(KEY, token, player);
				return 0;
			}));
		}
	}

	@Override
	public List<Component> descFull(int lv, String key, boolean alt, boolean isBook) {
		var ans = new ArrayList<>(super.descFull(lv, key, alt, isBook));
		var data = ClientEffectHandlers.getPlayerDataClientSide(KEY);
		if (data != null && data.timer > 0) {
			ans.add(CELang.ECHO.get(Component.literal(data.timer / 20 + "")
					.withStyle(ChatFormatting.DARK_AQUA)).withStyle(ChatFormatting.GRAY));
		}
		return ans;
	}

	@Override
	public Token getData(EchoEffect self) {
		return new Token();
	}

	@Override
	public TokenKey<Token> getKey() {
		return KEY;
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, heal(), alt), CELang.num(cd()));
	}

	@SerialClass
	public static class Token extends ConditionalToken implements NetworkSensitiveToken<Token> {

		@SerialClass.SerialField(toClient = true)
		private int timer;

		@Override
		public boolean tick(Player player) {
			timer--;
			return timer <= 0;
		}

		@Override
		public void onSync(@Nullable EchoEffect.Token token, Player player) {
			ClientEffectHandlers.echoEffectActivation(player);
		}

	}

}
