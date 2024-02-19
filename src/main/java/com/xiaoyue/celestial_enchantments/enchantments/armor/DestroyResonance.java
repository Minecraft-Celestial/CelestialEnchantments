package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.List;

public class DestroyResonance extends XCEnchBase {
    public DestroyResonance() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
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
    public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
        if (attacker instanceof LivingEntity livingEntity) {
            if (entity.getLastDamageSource() == null) return;
            List<LivingEntity> delimitedEntity = EntityUtils.getDelimitedMonster(entity, 6 + level);
            delimitedEntity.remove(entity);
            for (LivingEntity list : delimitedEntity) {
                DamageSource source = new DamageSource(entity.getLastDamageSource().typeHolder());
                list.hurt(source, level * 2);
            }
        }
    }
}