package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class QuickStepPuncture extends AttackEnch {
	public QuickStepPuncture() {
		super(Rarity.RARE);
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
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.isSprinting()) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + (lv * 0.16f)));
			target.knockback(lv * 0.3f, user.getX() - target.getX(), user.getZ() - target.getZ());
		}
	}

}
