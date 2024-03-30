package com.xiaoyue.celestial_enchantments.enchantments.trident;

import com.xiaoyue.celestial_enchantments.generic.TridentEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.Nullable;

public class SharpHalberdTip extends TridentEnch {

	public SharpHalberdTip() {
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
	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
		cache.addHurtModifier(DamageModifier.multTotal(1 + lv * 0.2f));
	}

}
