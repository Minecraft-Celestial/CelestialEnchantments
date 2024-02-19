package com.xiaoyue.celestial_enchantments.utils;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.ArrayList;
import java.util.Map;

public class IEnchUtils {

    public static ArrayList<Map.Entry<Enchantment, Integer>> getAllSlotsEnch(LivingEntity entity) {
        ArrayList<Map.Entry<Enchantment, Integer>> list = new ArrayList<>();
        for (ItemStack stack : entity.getAllSlots()) {
            if (stack.isEnchanted()) {
                Map<Enchantment, Integer> entries = EnchantmentHelper.getEnchantments(stack);
                list.addAll(entries.entrySet());
            }
        }
        return list;
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

    public static EquipmentSlot[] ARMOR = new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    public static EquipmentSlot[] MAIN_AND_OFF = new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND};

}
