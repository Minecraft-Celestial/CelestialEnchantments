package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class CelestialShelter extends CAttackEnch {
    public CelestialShelter() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS});
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
    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            float min = Math.min(event.getAmount(), entity.getMaxHealth() * 0.25f);
            event.setAmount(min);
        }
    }
}
