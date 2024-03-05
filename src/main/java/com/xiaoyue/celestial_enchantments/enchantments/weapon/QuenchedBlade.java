package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class QuenchedBlade extends AttackEnch {

	public QuenchedBlade() {
		super(Rarity.UNCOMMON);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 15) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 15);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (target.isOnFire()) {
			float remainingFireTicks = target.getRemainingFireTicks();
			float i = remainingFireTicks * 0.01f;
			cache.addHurtModifier(DamageModifier.multTotal(1 + lv * i));
		}
	}

}
