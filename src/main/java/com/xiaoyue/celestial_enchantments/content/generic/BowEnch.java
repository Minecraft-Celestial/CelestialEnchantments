package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class BowEnch extends XCEnchBase {

	protected BowEnch(Rarity rarity, EnchConfigData config) {
		super(rarity, Type.BOW, config);
	}

	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

}
