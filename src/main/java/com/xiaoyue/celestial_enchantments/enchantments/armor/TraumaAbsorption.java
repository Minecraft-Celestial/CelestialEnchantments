package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class TraumaAbsorption extends XCEnchBase {
    public TraumaAbsorption() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
        MinecraftForge.EVENT_BUS.addListener(this::onLivingDamage);
    }

    @Override
    public int getMinCost(int level) {
        return (level * 15) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 15);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isTradeable() {
        return super.isTradeable();
    }

    public void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        int level = EnchantmentHelper.getEnchantmentLevel(this, entity);
        if (level > 0) {
            float missHealth = entity.getMaxHealth() - entity.getHealth();
            entity.heal(missHealth * (level * 0.09f));
        }
    }
}
