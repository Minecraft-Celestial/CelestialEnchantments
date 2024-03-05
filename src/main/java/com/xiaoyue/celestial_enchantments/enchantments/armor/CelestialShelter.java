package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class CelestialShelter extends DefenceEnch {

	public CelestialShelter() {
		super(Rarity.VERY_RARE, Type.LEGS);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		cache.addDealtModifier(DamageModifier.nonlinearMiddle(1015, f -> Math.min(f, user.getMaxHealth() * 0.25f)));
	}

}
