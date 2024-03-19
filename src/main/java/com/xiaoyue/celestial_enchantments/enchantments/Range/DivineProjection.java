package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_enchantments.generic.BowEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class DivineProjection extends BowEnch {

	public DivineProjection() {
		super(Rarity.VERY_RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 25) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 28);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		var owner = arrow.getOwner();
		if (owner != null) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + owner.distanceTo(target) * 0.03f));
		}
	}

}
