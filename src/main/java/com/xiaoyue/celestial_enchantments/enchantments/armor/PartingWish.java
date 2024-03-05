package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.DeathEnch;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class PartingWish extends DeathEnch {
	public PartingWish() {
		super(Rarity.UNCOMMON, Type.HEAD);
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
	public void onDeath(LivingEntity entity, int level) {
		if (!(entity instanceof Player)) return;
		List<LivingEntity> players = EntityUtils.getExceptForCentralEntity(entity, 6, 2, livingEntity -> livingEntity instanceof Player);
		for (LivingEntity list : players) {
			list.heal(level * 8);
		}
	}

}
