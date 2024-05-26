package com.xiaoyue.celestial_enchantments.content.table;

import com.google.common.collect.Lists;
import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import com.xiaoyue.celestial_enchantments.data.EnchType;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class CelestialEnchantmentHelper {

	private static int maxLevel(CEBaseEnchantment ce, int level) {
		int lv = ce.getMaxLevel();
		while (lv > 0 && level < ce.getMinCost(lv)) lv--;
		return lv;
	}

	public static List<EnchantmentInstance> selectEnchantment(RandomSource rand, ItemStack stack, int slot, int level) {
		List<EnchantmentInstance> list = Lists.newArrayList();
		int val = stack.getEnchantmentValue();
		if (val <= 0) return list;
		boolean isBook = stack.is(Items.BOOK);
		List<EnchantmentInstance> basic = new ArrayList<>();
		List<EnchantmentInstance> advance = new ArrayList<>();
		List<EnchantmentInstance> legendary = new ArrayList<>();

		level += 1 + rand.nextInt(val / 4 + 1) + rand.nextInt(val / 4 + 1);
		float randomBonus = 1 + (rand.nextFloat() + rand.nextFloat() - 1.0F) * 0.15F;
		level = Math.max(Math.round(level * randomBonus), 1);

		for (Enchantment e : ForgeRegistries.ENCHANTMENTS) {
			if (e instanceof CEBaseEnchantment ce &&
					(e.canApplyAtEnchantingTable(stack) || isBook && e.isAllowedOnBooks())) {
				var max = maxLevel(ce, level);
				if (max <= 0) continue;
				var ins = new EnchantmentInstance(ce, max);
				if (ce.config.level().type() == EnchType.NORMAL) {
					basic.add(ins);
				}
				if (ce.config.level().type() == EnchType.TREASURE) {
					advance.add(ins);
				}
				if (ce.config.level().type() == EnchType.LEGENDARY) {
					legendary.add(ins);
				}
			}
		}
		if (slot >= 2) {
			WeightedRandom.getRandomItem(rand, legendary).ifPresent(list::add);
		}
		if (slot >= 1) {
			WeightedRandom.getRandomItem(rand, advance).ifPresent(list::add);
		}
		if (slot >= 0) {
			WeightedRandom.getRandomItem(rand, basic).ifPresent(list::add);
		}
		return list;
	}


}
