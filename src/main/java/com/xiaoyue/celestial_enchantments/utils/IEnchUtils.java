package com.xiaoyue.celestial_enchantments.utils;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import dev.xkmc.l2core.init.reg.ench.LegacyEnchantment;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IEnchUtils {

	public static final TagKey<Item> SHIELD = TagKey.create(Registries.ITEM, CelestialEnchantments.loc("enchantable/shield"));
	public static final TagKey<Item> HOE = TagKey.create(Registries.ITEM, CelestialEnchantments.loc("enchantable/hoe"));
	public static final TagKey<Item> AXE = TagKey.create(Registries.ITEM, CelestialEnchantments.loc("enchantable/axe"));
	public static final TagKey<Item> BOW_AND_CROSSBOW = TagKey.create(Registries.ITEM, CelestialEnchantments.loc("enchantable/bow_and_crossbow"));

	public static Map<CEBaseEnchantment, Integer> getAllEnch(LivingEntity entity) {
		return getEnch(entity, EquipmentSlot.values());
	}

	public static Map<CEBaseEnchantment, Integer> getArmorEnch(LivingEntity entity) {
		return getEnch(entity, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET);
	}

	public static Map<CEBaseEnchantment, Integer> getHeldEnch(LivingEntity entity) {
		return getEnch(entity, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND);
	}

	public static Map<CEBaseEnchantment, Integer> getEnch(LivingEntity entity, EquipmentSlot... slots) {
		List<EquipmentSlot> filter = List.of(slots);
		Map<CEBaseEnchantment, Integer> ans = new LinkedHashMap<>();
		for (EquipmentSlot slot : EquipmentSlot.values()) {
			if (!filter.contains(slot)) continue;
			ItemStack stack = entity.getItemBySlot(slot);
			if (stack.isEmpty() || !stack.isEnchanted()) continue;
			for (var holder : LegacyEnchantment.findAll(stack, CEBaseEnchantment.class, true)) {
				CEBaseEnchantment ench = holder.val();
				if (!ench.isEnabled() || !List.of(ench.slots).contains(slot)) continue;
				ans.merge(ench, Math.min(ench.getMaxLevel(), holder.lv()), Integer::sum);
			}
		}
		return ans;
	}
}
