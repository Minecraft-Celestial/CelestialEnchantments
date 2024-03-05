package com.xiaoyue.celestial_enchantments.generic;

import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;

public class TridentEnch extends XCEnchBase {

	protected TridentEnch(Rarity rarity) {
		super(rarity, Type.WEAPON);
	}

	public void hurtTarget(ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
	}

}
