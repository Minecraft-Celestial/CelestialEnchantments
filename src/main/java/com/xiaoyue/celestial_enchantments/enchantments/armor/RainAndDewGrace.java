package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.intf.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEvent;

public class RainAndDewGrace extends XCEnchBase implements LivingTickEnch {
    public RainAndDewGrace() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
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
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (entity.tickCount % 100 == 0) {
                entity.heal(level);
            }
        }
    }
}
