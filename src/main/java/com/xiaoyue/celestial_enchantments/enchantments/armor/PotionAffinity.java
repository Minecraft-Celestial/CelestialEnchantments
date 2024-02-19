package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class PotionAffinity extends XCEnchBase {
    public PotionAffinity() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
        MinecraftForge.EVENT_BUS.addListener(this::onAddedEffect);
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
    public boolean isTreasureOnly() {
        return true;
    }

    public void onAddedEffect(MobEffectEvent.Added event) {
        LivingEntity entity = event.getEntity();
        int level = EnchantmentHelper.getEnchantmentLevel(this, entity);
        if (level > 0) {
            MobEffect effect = event.getEffectInstance().getEffect();
            int duration = event.getEffectInstance().getDuration();
            int amplifier = event.getEffectInstance().getAmplifier();
            event.getEffectInstance().update(new MobEffectInstance(effect, (int) (duration * (1 + level * 0.15f)), amplifier));
        }
    }
}
