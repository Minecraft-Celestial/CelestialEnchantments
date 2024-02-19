package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class QuickStepPuncture extends CAttackEnch {
    public QuickStepPuncture() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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

    @Override
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            if (attacker.isSprinting()) {
                event.setAmount(event.getAmount() * (1 + (level * 0.16f)));
                target.knockback(level * 0.3f, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
            }
        }
    }
}
