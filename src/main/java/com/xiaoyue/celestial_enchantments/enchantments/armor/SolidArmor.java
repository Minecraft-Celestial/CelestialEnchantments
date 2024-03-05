package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class SolidArmor extends DefenceEnch {
	public SolidArmor() {
		super(Rarity.VERY_RARE, Type.CHEST);
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
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (user.getHealth() < user.getMaxHealth() / 2) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - lv * 0.12f));
		}
	}

}
