package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FireproofBoots extends DefenceEnch {

	public FireproofBoots() {
		super(Rarity.UNCOMMON, Type.FEET);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 28) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 28);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.FIRE_PROTECTION;
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.IS_FIRE)) {
			cache.addDealtModifier(DamageModifier.multTotal(0.85f));
		}
	}

	@Override
	public boolean onAttackedImpl(LivingEntity user, AttackCache cache, int lv) {
		return getSource(cache).is(DamageTypes.HOT_FLOOR);
	}

}
