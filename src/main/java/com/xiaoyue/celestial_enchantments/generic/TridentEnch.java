package com.xiaoyue.celestial_enchantments.generic;

import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.Nullable;

public class TridentEnch extends XCEnchBase {

	protected TridentEnch(Rarity rarity) {
		super(rarity, Type.TRIDENT);
	}

	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
	}

}
