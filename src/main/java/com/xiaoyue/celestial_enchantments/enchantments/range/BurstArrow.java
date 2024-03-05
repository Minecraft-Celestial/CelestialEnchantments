package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_enchantments.generic.BowEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class BurstArrow extends BowEnch {

	public BurstArrow() {
		super(Rarity.VERY_RARE);
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
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		if (chance(target, 0.2 * lv)) {
			GeneralEventHandler.schedule(() -> target.level().explode(arrow, arrow.getX(), arrow.getY(), arrow.getZ(), 1.0f,
					Level.ExplosionInteraction.NONE));
		}
	}

}
