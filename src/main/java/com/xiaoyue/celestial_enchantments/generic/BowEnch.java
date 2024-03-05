package com.xiaoyue.celestial_enchantments.generic;

import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class BowEnch extends XCEnchBase {

	protected BowEnch(Rarity rarity) {
		super(rarity, Type.BOW);
	}

	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

}
