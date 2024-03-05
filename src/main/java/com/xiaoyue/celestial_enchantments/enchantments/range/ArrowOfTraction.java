package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.BowEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

import java.util.List;

public class ArrowOfTraction extends BowEnch {

	public ArrowOfTraction() {
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
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, lv + 1, 2);
		for (LivingEntity list : entities) {
			list.teleportTo(target.getX(), target.getY(), target.getZ());
		}
	}

}