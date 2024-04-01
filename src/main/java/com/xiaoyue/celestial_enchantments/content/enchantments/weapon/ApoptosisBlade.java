package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ApoptosisBlade extends WeaponEnch {

    public ApoptosisBlade() {
        super(Rarity.UNCOMMON, EnchConfigData.NORMAL_5);
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            EntityUtils.addEct(livingEntity, MobEffects.WITHER, level * 40, 0);
        }
    }
}
