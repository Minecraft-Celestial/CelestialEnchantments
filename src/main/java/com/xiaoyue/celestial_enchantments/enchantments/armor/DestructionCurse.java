package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DestructionCurse extends CAttackEnch {
    public DestructionCurse() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 22) - 1;
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
    public boolean isCurse() {
        return true;
    }

    @Override
    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            if (event.getSource().is(DamageTypes.EXPLOSION)) {
                event.setAmount(event.getAmount() * 1.4f);
            } else {
                event.setAmount(event.getAmount() * 1.25f);
            }
        }
    }
}
