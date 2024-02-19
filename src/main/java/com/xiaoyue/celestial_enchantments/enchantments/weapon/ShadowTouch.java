package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.IAttackUtils;
import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.LightLayer;

public class ShadowTouch extends XCEnchBase {
    public ShadowTouch() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if (LevelUtils.isServerLevel(attacker.level())) {
                int brightness = attacker.level().getBrightness(LightLayer.BLOCK, attacker.blockPosition());
                if (brightness <= 5) {
                    IAttackUtils.attackEntitySecondary(attacker.damageSources().fellOutOfWorld(), level, livingEntity);
                }
            }
        }
    }
}
