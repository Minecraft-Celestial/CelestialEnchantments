package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EyeInShadow extends XCEnchBase implements LivingTickEnch {
    public EyeInShadow() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 25) - 1;
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
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (LevelUtils.isServerLevel(entity.level())) {
                int brightness = entity.level().getBrightness(LightLayer.BLOCK, entity.blockPosition());
                if (brightness < 5) {
                    EntityUtils.addEct(entity, MobEffects.NIGHT_VISION, 300, 0);
                }
            }
        }
    }
}
