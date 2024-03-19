package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCrack extends WeaponEnch {

	public DestructionCrack() {
		super(Rarity.UNCOMMON);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.DESTRUCTED.get(), 1200));
		}
	}
}
