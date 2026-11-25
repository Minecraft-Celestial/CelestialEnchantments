package com.xiaoyue.celestial_enchantments.content.enchantments.shield;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.ShieldEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2core.capability.conditionals.ConditionalToken;
import dev.xkmc.l2core.capability.conditionals.TokenKey;
import dev.xkmc.l2core.events.SchedulerHandler;
import dev.xkmc.l2core.init.L2LibReg;
import dev.xkmc.l2serial.serialization.marker.SerialClass;
import dev.xkmc.l2serial.serialization.marker.SerialField;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;

public class ConstraintsShield extends ShieldEnch {

	private static int prepare() {
		return CEModConfig.SERVER.ench.shield.constraintsShieldPrepare.get();
	}

	private static double damageMult() {
		return CEModConfig.SERVER.ench.shield.constraintsShieldDamageMult.get();
	}

	public static final TokenKey<Token> KEY = TokenKey.of(CelestialEnchantments.loc("constraints_shield"));

	public ConstraintsShield() {
		super(Rarity.RARE, EnchData.treasure(3, SHIELD));
	}

	@Override
	public void onShieldBlock(LivingShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		if (entity instanceof ServerPlayer player) {
			var data = L2LibReg.CONDITIONAL.type().getOrCreate(player);
			var token = data.getOrCreateData(KEY, Token::new);
			if (token.cec < prepare()) {
				token.cec++;
			} else {
				token.cec = 0;
				float dmg = event.getBlockedDamage() * level * (float) damageMult();
				SchedulerHandler.schedule(() -> attacker.hurt(CCDamageTypes.magic(entity), dmg));
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(prepare()), CELang.perc(lv, damageMult(), alt));
	}

	@SerialClass
	public static class Token extends ConditionalToken {

		@SerialField
		public int cec;

	}

}
