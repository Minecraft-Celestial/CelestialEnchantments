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
			roll(val - 20, legendary, list, rand, isBook);
		}
		if (slot >= 1) {
			roll(val - 10, advance, list, rand, isBook);
		}
		if (slot >= 0) {
			roll(val, basic, list, rand, isBook);
		}
		return list;
	}

	private static void roll(int val, List<EnchantmentInstance> legendary, List<EnchantmentInstance> list, RandomSource rand, boolean isBook) {
		if (val < 0) val = 0;
		double rolls = 1 + rand.nextDouble() * val / 10;
		int roll = (int) rolls;
		if (rand.nextDouble() < rolls - roll) roll++;
		for (int i = 0; i < roll; i++) {
			if (!list.isEmpty() && isBook) return;
			legendary.removeIf(e -> CelestialEnchantmentHelper.incompatible(e, list));
			WeightedRandom.getRandomItem(rand, legendary).ifPresent(list::add);
		}
	}

	private static boolean incompatible(EnchantmentInstance e, List<EnchantmentInstance> list) {
		for (var x : list) {
			if (!x.enchantment.isCompatibleWith(e.enchantment)) {
				return true;
			}
		}
		return false;
	}


}
