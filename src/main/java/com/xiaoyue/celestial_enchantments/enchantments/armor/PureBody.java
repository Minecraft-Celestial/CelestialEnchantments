package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.intf.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PureBody extends XCEnchBase implements LivingTickEnch {
    public PureBody() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 30) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 30);
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (!entity.getActiveEffects().isEmpty()) {
                entity.removeAllEffects();
            }
        }
    }
}
