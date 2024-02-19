package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class GiftOfThunderGod extends CAttackEnch {
    public GiftOfThunderGod() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
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
    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            if (event.getSource().getDirectEntity() instanceof LightningBolt) {
                entity.heal(entity.getMaxHealth() - entity.getHealth());
                EntityUtils.addEct(entity, MobEffects.MOVEMENT_SPEED, 200, level - 1);
                EntityUtils.addEct(entity, MobEffects.DAMAGE_RESISTANCE, 200, level - 1);
            }
        }
    }
}
