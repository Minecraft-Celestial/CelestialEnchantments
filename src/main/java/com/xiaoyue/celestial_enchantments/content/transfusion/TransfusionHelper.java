package com.xiaoyue.celestial_enchantments.content.transfusion;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import javax.annotation.Nullable;
import java.util.*;

public class TransfusionHelper {

	private static ItemStack setEnch(ItemStack stack, Map<Enchantment, Integer> map) {
		if (stack.is(Items.BOOK) || stack.is(Items.ENCHANTED_BOOK)) {
			stack = new ItemStack(Items.ENCHANTED_BOOK);
		}
		EnchantmentHelper.setEnchantments(map, stack);
		return stack;
	}

	public static Pair<ItemStack, ItemStack> transfuse(ItemStack a, ItemStack b) {
		var amap = EnchantmentHelper.getEnchantments(a);
		var bmap = EnchantmentHelper.getEnchantments(b);

		var abk = a.is(Items.BOOK) || a.is(Items.ENCHANTED_BOOK);
		var bbk = b.is(Items.BOOK) || b.is(Items.ENCHANTED_BOOK);

		var a2b = new LinkedHashMap<Enchantment, Integer>();
		for (var ent : amap.entrySet()) {
			if (bbk || ent.getKey().canEnchant(b)) {
				a2b.put(ent.getKey(), ent.getValue());
			}
		}
		for (var e : a2b.keySet()) amap.remove(e);

		var b2a = new LinkedHashMap<Enchantment, Integer>();
		for (var ent : bmap.entrySet()) {
			if (abk || ent.getKey().canEnchant(a)) {
				b2a.put(ent.getKey(), ent.getValue());
			}
		}
		for (var e : b2a.keySet()) bmap.remove(e);

		Set<Enchantment> rmb = new HashSet<>();
		for (var e : a2b.keySet()) {
			for (var x : bmap.keySet()) {
				if (e == x || !e.isCompatibleWith(x)) {
					rmb.add(x);
				}
			}
		}
		for (var e : rmb) bmap.remove(e);
		bmap.putAll(a2b);

		Set<Enchantment> rma = new HashSet<>();
		for (var e : b2a.keySet()) {
			for (var x : amap.keySet()) {
				if (e == x || !e.isCompatibleWith(x)) {
					rma.add(x);
				}
			}
		}
		for (var e : rma) amap.remove(e);
		amap.putAll(b2a);

		return Pair.of(setEnch(a.copy(), amap), setEnch(b.copy(), bmap));
	}

	public static ItemStack clean(ItemStack a) {
		var amap = EnchantmentHelper.getEnchantments(a);
		Set<Enchantment> rma = new HashSet<>();
		for (var e : amap.keySet()) {
			if (e.isCurse()) {
				rma.add(e);
			}
		}
		for (var e : rma) amap.remove(e);
		ItemStack copy = a.copy();
		if (copy.getBaseRepairCost() > 0) {
			copy.setRepairCost(0);
		}
		return setEnch(a, amap);
	}

	@Nullable
	public static Pair<ItemStack, ItemStack> split(ItemStack a, long seed) {
		var rand = RandomSource.create(seed);
		var map = EnchantmentHelper.getEnchantments(a);
		if (map.isEmpty()) return null;
		if (map.size() == 1) {
			var ent = new ArrayList<>(map.entrySet()).get(0);
			if (ent.getValue() <= 1) return null;
			var ans = Map.of(ent.getKey(), ent.getValue() - 1);
			return Pair.of(setEnch(a.copy(), ans), setEnch(new ItemStack(Items.ENCHANTED_BOOK), ans));
		}
		var ent = new ArrayList<>(map.entrySet()).get(rand.nextInt(map.size()));
		map.remove(ent.getKey());
		var ans = Map.of(ent.getKey(), ent.getValue());
		return Pair.of(setEnch(a.copy(), map), setEnch(new ItemStack(Items.ENCHANTED_BOOK), ans));
	}

}
