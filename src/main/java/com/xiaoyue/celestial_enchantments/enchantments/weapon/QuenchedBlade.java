package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class QuenchedBlade extends CAttackEnch {
    public QuenchedBlade() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            if (target.isOnFire()) {
                float remainingFireTicks = target.getRemainingFireTicks();
                float i = remainingFireTicks * 0.01f;
                event.setAmount(event.getAmount() * (1 + (level * i)));
            }
        }
    }
}
