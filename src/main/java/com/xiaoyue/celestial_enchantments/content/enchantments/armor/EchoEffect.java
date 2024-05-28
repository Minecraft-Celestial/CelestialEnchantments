package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.l2library.capability.conditionals.*;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EchoEffect extends DefenceEnch implements TokenProvider<EchoEffect.Token, EchoEffect>, Context {

	private static final TokenKey<Token> KEY = TokenKey.of(CelestialEnchantments.loc("echo"));
	
	private static double heal() {
		return 0.05;
	}

	private static int cd() {
		return 60;
	}

	public EchoEffect() {
		super(Rarity.VERY_RARE, Type.LEGS, EnchData.specialHigh(3, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (user instanceof Player player) {
			cache.addDealtModifier(DamageModifier.nonlinearFinal(1010, v -> {
				if (v < user.getHealth()) return v;
				var data = ConditionalData.HOLDER.get(player);
				if (data.hasData(KEY)) return v;
				player.heal(player.getMaxHealth() * v * (float) heal());
				data.getOrCreateData(this, this).timer = cd() * 20;
				return 0;
			}));
		}
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
	public static class Token extends ConditionalToken {

		@SerialClass.SerialField
		private int timer;

		@Override
		public boolean tick(Player player) {
			timer--;
			return timer <= 0;
		}
	}

}
