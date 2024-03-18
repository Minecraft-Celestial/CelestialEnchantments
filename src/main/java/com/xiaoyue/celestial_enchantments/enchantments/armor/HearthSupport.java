package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class HearthSupport extends ArmorEnch {
    public HearthSupport() {
        super(Rarity.RARE, Type.HEAD);
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
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.THORNS
                && enchantment != CEEnchantments.FROST_THORNS.get();
    }

    @Override
    public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
        if (attacker instanceof LivingEntity livingEntity) {
            livingEntity.setSecondsOnFire(level * 40);
        }
    }

}
