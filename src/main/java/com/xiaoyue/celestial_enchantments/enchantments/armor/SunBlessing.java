package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEvent;

public class SunBlessing extends XCEnchBase implements LivingTickEnch {
    public SunBlessing() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
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
    public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
        if (level > 0) {
            if (entity.level().isDay()) {
                EntityUtils.addEct(entity, MobEffects.DAMAGE_BOOST, 40, level - 1);
            }
        }
    }
}
