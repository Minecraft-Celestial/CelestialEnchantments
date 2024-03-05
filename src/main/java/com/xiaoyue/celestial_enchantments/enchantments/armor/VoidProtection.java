package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public class VoidProtection extends DefenceEnch {

	public VoidProtection() {
		super(Rarity.VERY_RARE, Type.ARMOR);
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
	public void onDamaged(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypes.FELL_OUT_OF_WORLD)) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - lv * 0.08f));
		}
	}

}
