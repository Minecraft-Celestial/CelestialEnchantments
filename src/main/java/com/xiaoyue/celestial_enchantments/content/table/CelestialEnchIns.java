package com.xiaoyue.celestial_enchantments.content.table;

import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.item.enchantment.Enchantment;

public class CelestialEnchIns extends WeightedEntry.IntrusiveBase {

	public final Enchantment enchantment;

	public final int level;

	public CelestialEnchIns(Enchantment pEnchantment, int pLevel, int averager) {
		super(pEnchantment.getRarity().getWeight() + averager);
		this.enchantment = pEnchantment;
		this.level = pLevel;
	}
}