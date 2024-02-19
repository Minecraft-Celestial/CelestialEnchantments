package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.List;

public class DeathHatred extends CAttackEnch {
    public DeathHatred() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
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
    public void onUnderDeath(LivingDeathEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            List<LivingEntity> players = EntityUtils.getExceptForCentralEntity(entity, 6, 2, livingEntity -> livingEntity instanceof Monster);
            for (LivingEntity list : players) {
                DamageSource damageSource = new DamageSource(entity.damageSources().magic().typeHolder());
                list.hurt(damageSource, level * 15);
            }
        }
    }
}
