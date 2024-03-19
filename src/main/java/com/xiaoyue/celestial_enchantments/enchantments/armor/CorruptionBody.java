package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CorruptionBody extends DefenceEnch {

	public CorruptionBody() {
		super(Rarity.UNCOMMON, Type.LEGS);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 6) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 6);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.CORRUPTION.get(), 1200, level - 1));
		}
	}
}
