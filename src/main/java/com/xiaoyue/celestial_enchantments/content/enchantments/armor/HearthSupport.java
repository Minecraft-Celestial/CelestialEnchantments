package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class HearthSupport extends ArmorEnch {

    public HearthSupport() {
        super(Rarity.RARE, Type.ARMOR, EnchConfigData.NORMAL_5, REACTIVE);
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
