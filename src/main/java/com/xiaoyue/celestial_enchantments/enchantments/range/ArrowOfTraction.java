package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class ArrowOfTraction extends XCEnchBase {
    public ArrowOfTraction() {
        super(Rarity.RARE, IEnchUtils.BOW_AND_CROSSBOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
        if (entity instanceof LivingEntity livingEntity) {
            List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(livingEntity, level + 1, 2);
            for (LivingEntity list : entities) {
                list.teleportTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
            }
        }
    }
}