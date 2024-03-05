package com.xiaoyue.celestial_enchantments.utils;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.HashMap;
import java.util.Map;

public class IEnchUtils {

	public static Map<Enchantment, Integer> getAllEnch(LivingEntity entity) {
		return getEnch(entity, EquipmentSlot.values());
	}

	public static Map<Enchantment, Integer> getArmorEnch(LivingEntity entity) {
		return getEnch(entity, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET);
	}

	public static Map<Enchantment, Integer> getHeldEnch(LivingEntity entity) {
		Map<Enchantment, Integer> ans = new HashMap<>();
		var stack = entity.getUseItem();
		EquipmentSlot slot = entity.getMainHandItem() == stack ? EquipmentSlot.MAINHAND :
				entity.getOffhandItem() == stack ? EquipmentSlot.OFFHAND : null;
		if (slot == null) return ans;
		if (stack.isEnchanted()) {
			Map<Enchantment, Integer> entries = EnchantmentHelper.getEnchantments(stack);
			for (var e : entries.entrySet()) {
				if (e.getKey() instanceof XCEnchBase xc && xc.slots.contains(slot)) {
					ans.compute(e.getKey(), (k, v) -> (v == null ? 0 : v) + e.getValue());
				}
			}
		}
		return ans;
	}

	public static Map<Enchantment, Integer> getEnch(LivingEntity entity, EquipmentSlot... slots) {
		Map<Enchantment, Integer> ans = new HashMap<>();
		for (EquipmentSlot slot : slots) {
			ItemStack stack = entity.getItemBySlot(slot);
			if (stack.isEnchanted()) {
				Map<Enchantment, Integer> entries = EnchantmentHelper.getEnchantments(stack);
				for (var e : entries.entrySet()) {
					if (e.getKey() instanceof XCEnchBase xc && xc.slots.contains(slot)) {
						ans.compute(e.getKey(), (k, v) -> (v == null ? 0 : v) + e.getValue());
					}
				}
			}
		}
		return ans;
	}

	public static ItemStack addMaxEnchBook(Enchantment enchantment) {
		return EnchantedBookItem.createForEnchantment(new EnchantmentInstance(enchantment, enchantment.getMaxLevel()));
	}

	public static ItemStack addMinEnchBook(Enchantment enchantment) {
		return EnchantedBookItem.createForEnchantment(new EnchantmentInstance(enchantment, 1));
	}

	public static EnchantmentCategory SHIELD = EnchantmentCategory.create("shield", item -> item instanceof ShieldItem);
	public static EnchantmentCategory TOOL = EnchantmentCategory.create("tool", item -> item instanceof PickaxeItem || item instanceof AxeItem || item instanceof ShovelItem || item instanceof HoeItem);
	public static EnchantmentCategory HOE = EnchantmentCategory.create("hoe", item -> item instanceof HoeItem);
	public static EnchantmentCategory BOW_AND_CROSSBOW = EnchantmentCategory.create("bow_and_crossbow", item -> item instanceof ShieldItem || item instanceof CrossbowItem);

	public static EquipmentSlot[] ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
	public static EquipmentSlot[] MAIN_AND_OFF = new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND};

}
