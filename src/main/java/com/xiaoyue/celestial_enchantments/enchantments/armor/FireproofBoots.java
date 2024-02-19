package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class FireproofBoots extends CAttackEnch {
    public FireproofBoots() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
        MinecraftForge.EVENT_BUS.addListener(this::onLivingAtkEvt);
    }

    @Override
    public int getMinCost(int level) {
        return (level * 28) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 28);
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.FIRE_PROTECTION;
    }

    @Override
    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            if (event.getSource().is(DamageTypes.ON_FIRE)) {
                event.setAmount(event.getAmount() * 0.85f);
            }
        }
    }

    public void onLivingAtkEvt(LivingAttackEvent event) {
        int level = EnchantmentHelper.getEnchantmentLevel(this, event.getEntity());
        if (level > 0) {
            if (event.getSource().is(DamageTypes.HOT_FLOOR)) {
                event.setCanceled(true);
            }
        }
    }
}
