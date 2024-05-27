package com.xiaoyue.celestial_enchantments.content.table;

import com.google.common.collect.Lists;
import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import com.xiaoyue.celestial_enchantments.data.EnchType;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CelestialEnchantmentHelper {

	private static final double EXTRA_ROLL_PER_AFFINITY = 0.1;
	private static final double EXTRA_WEIGHT_PER_AFFINITY = 0.1;

	private static int maxLevel(CEBaseEnchantment ce, int level) {
		int lv = ce.getMaxLevel();
		while (lv > 0 && level < ce.getMinCost(lv)) lv--;
		return lv;
	}

	public static List<CelestialEnchIns> selectEnchantment(
			RandomSource rand, ItemStack stack, int slot, int level,
			Set<Enchantment> ban, int averager, int levelBonus
	) {
		List<CelestialEnchIns> list = Lists.newArrayList();
		int val = stack.getEnchantmentValue();
		if (val <= 0) return list;
		boolean isBook = stack.is(Items.BOOK);
		List<CelestialEnchIns> basic = new ArrayList<>();
		List<CelestialEnchIns> advance = new ArrayList<>();
		List<CelestialEnchIns> legendary = new ArrayList<>();

		level += val / 2 + Math.max(0, val - 10) / 2 + Math.max(0, val - 20) / 2;
		averager += (int) (val * EXTRA_WEIGHT_PER_AFFINITY);

		for (Enchantment e : ForgeRegistries.ENCHANTMENTS) {
			if (e instanceof CEBaseEnchantment ce &&
					(e.canApplyAtEnchantingTable(stack) || isBook && e.isAllowedOnBooks())) {
				var max = Math.min(ce.getMaxLevel(), maxLevel(ce, level) + levelBonus);
				if (max <= 0) continue;
				if (ban.contains(e)) continue;
				var ins = new CelestialEnchIns(ce, max, averager);
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
			if (list.isEmpty()) return list;
		}
		if (slot >= 1) {
			roll(val - 10, advance, list, rand, isBook);
			if (list.isEmpty()) return list;
		}
		if (slot >= 0) {
			roll(val, basic, list, rand, isBook);
			if (list.isEmpty()) return list;
		}
		return list;
	}

	private static void roll(int val, List<CelestialEnchIns> legendary, List<CelestialEnchIns> list, RandomSource rand, boolean isBook) {
		if (val < 0) val = 0;
		double rolls = 1 + rand.nextDouble() * val * EXTRA_ROLL_PER_AFFINITY;
		int roll = (int) rolls;
		if (rand.nextDouble() < rolls - roll) roll++;
		for (int i = 0; i < roll; i++) {
			if (!list.isEmpty() && isBook) return;
			legendary.removeIf(e -> CelestialEnchantmentHelper.incompatible(e, list));
			WeightedRandom.getRandomItem(rand, legendary).ifPresent(list::add);
		}
	}

	private static boolean incompatible(CelestialEnchIns e, List<CelestialEnchIns> list) {
		for (var x : list) {
			if (!x.enchantment.isCompatibleWith(e.enchantment)) {
				return true;
			}
		}
		return false;
	}


}
