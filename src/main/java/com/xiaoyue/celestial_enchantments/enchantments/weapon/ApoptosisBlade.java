package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ApoptosisBlade extends WeaponEnch {

    public ApoptosisBlade() {
        super(Rarity.UNCOMMON);
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
            EntityUtils.addEct(livingEntity, MobEffects.WITHER, level * 40, 0);
        }
    }
}
