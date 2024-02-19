package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.event.entity.living.LivingEvent;

public class BornInShadow extends XCEnchBase implements LivingTickEnch {
    public BornInShadow() {
        super(Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (LevelUtils.isServerLevel(entity.level())) {
                int brightness = entity.level().getBrightness(LightLayer.BLOCK, entity.blockPosition());
                if (brightness < 5) {
                    if (entity.tickCount % 100 == 0) {
                        if (Math.random() > level * 0.1) {
                            entity.getMainHandItem().setDamageValue(entity.getMainHandItem().getDamageValue() - 1);
                        }
                    }
                }
            }
        }
    }
}
