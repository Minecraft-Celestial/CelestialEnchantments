package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FrostThorns extends ArmorEnch {
	public FrostThorns() {
		super(Rarity.RARE, Type.CHEST);
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
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.THORNS;
	}

	@Override
	public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			DamageSource source = new DamageSource(entity.damageSources().freeze().typeHolder());
			livingEntity.hurt(source, level);
			EntityUtils.addEct(livingEntity, MobEffects.MOVEMENT_SLOWDOWN, 40 * level, level - 1);
		}
	}

}
