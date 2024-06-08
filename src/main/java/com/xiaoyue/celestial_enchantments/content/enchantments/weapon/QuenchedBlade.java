package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class QuenchedBlade extends AttackEnch {

	private static double atk() {
		return CEModConfig.COMMON.ench.weapon.quenchedBladeDamagePerSecond.get();
	}

	private static int maxFire() {
		return CEModConfig.COMMON.ench.weapon.quenchedBladeMaxFire.get();
	}

	public QuenchedBlade() {
		super(Rarity.VERY_RARE, EnchData.treasure(3, A300));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (target.isOnFire()) {
			float i = Math.min(maxFire(), target.getRemainingFireTicks() * 0.05f) * (float) atk();
			cache.addHurtModifier(DamageModifier.multBase(lv * i));
			target.clearFire();
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.percSmall(lv, atk(), alt), CELang.perc(lv, atk() * maxFire(), alt));
	}
}
