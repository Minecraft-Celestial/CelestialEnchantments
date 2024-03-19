package com.xiaoyue.celestial_enchantments.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class Destructed extends MobEffect {

	public Destructed() {
		super(MobEffectCategory.HARMFUL, 16750848);
	}

	@Override
	public void applyEffectTick(LivingEntity le, int pAmplifier) {
		le.invulnerableTime = 0;
	}

	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return true;
	}
}