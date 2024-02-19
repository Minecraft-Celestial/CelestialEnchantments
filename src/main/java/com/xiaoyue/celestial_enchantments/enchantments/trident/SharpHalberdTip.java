package com.xiaoyue.celestial_enchantments.enchantments.trident;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SharpHalberdTip extends XCEnchBase {
    public SharpHalberdTip() {
        super(Rarity.VERY_RARE, EnchantmentCategory.TRIDENT, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 6) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 6);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
