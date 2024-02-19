package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class VoidProtection extends XCEnchBase {
    public VoidProtection() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR, IEnchUtils.ARMOR);
    }

    @Override
    public int getMinCost(int level) {
        return (level * 10) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 10);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getDamageProtection(int level, DamageSource source) {
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD)) {
            return level * 2;
        }
        return super.getDamageProtection(level, source);
    }
}
