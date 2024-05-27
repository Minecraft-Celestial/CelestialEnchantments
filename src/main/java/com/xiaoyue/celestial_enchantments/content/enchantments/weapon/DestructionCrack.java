package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCrack extends WeaponEnch {

	public DestructionCrack() {
		super(Rarity.VERY_RARE, EnchData.specialHigh(1, INFLICT));
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.DESTRUCTED.get(), 1200));
		}
	}

}
