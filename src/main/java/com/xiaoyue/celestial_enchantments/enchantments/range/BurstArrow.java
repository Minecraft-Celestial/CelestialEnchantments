package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class BurstArrow extends XCEnchBase {
    public BurstArrow() {
        super(Rarity.VERY_RARE, IEnchUtils.BOW_AND_CROSSBOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
        if (entity instanceof LivingEntity target) {
            if (LevelUtils.isServerLevel(target.level())) {
                if (Math.random() < 0.2 * level) {
                    target.level().explode(attacker, target.getX(), target.getY(), target.getZ(), 1.0f, Level.ExplosionInteraction.NONE);
                }
            }
        }
    }
}
