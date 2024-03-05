package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class TheSourceOfSin extends ArmorEnch {

	public TheSourceOfSin() {
		super(Rarity.VERY_RARE, Type.CHEST);
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
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			if (chance(user, level * 0.2)) {
				List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(livingEntity, 3, 2);
				for (LivingEntity list : entities) {
					list.setLastHurtByMob(livingEntity);
					list.setLastHurtMob(livingEntity);
				}
			}
		}
	}

}
