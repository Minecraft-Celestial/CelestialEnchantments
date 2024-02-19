package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.LivingHealEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHealEvent;

public class OriginOfLife extends XCEnchBase implements LivingHealEnch {
    public OriginOfLife() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 24) - 1;
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
    public void onLivingHeal(LivingHealEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (Math.random() > 0.5) {
                if (Math.random() > 0.5) {
                    EntityUtils.addEct(entity, MobEffects.MOVEMENT_SPEED, 100, 0);
                } else {
                    EntityUtils.addEct(entity, MobEffects.DAMAGE_RESISTANCE, 100, 0);
                }
            }
        }
    }
}
