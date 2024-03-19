package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SuppressionBlade extends WeaponEnch {
	public SuppressionBlade() {
		super(Rarity.RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 25) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 28);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int level) {
		if (target instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.SUPPRESSED.get(), 1200));
		}
	}
}
