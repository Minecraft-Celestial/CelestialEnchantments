package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DestructionCrack extends XCEnchBase {
    public DestructionCrack() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
    public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getPersistentData().putBoolean("destruction_crack", true);
        }
    }
}
