package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class UpwardPick extends WeaponEnch {
	public UpwardPick() {
		super(Rarity.RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 10) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 10);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isTradeable() {
		return super.isTradeable();
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
		if (entity instanceof LivingEntity livingEntity) {
			EntityUtils.addEct(livingEntity, MobEffects.LEVITATION, 3, level + 3);
		}
	}

}