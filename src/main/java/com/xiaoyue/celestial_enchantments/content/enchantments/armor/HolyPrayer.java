package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class HolyPrayer extends ArmorEnch {

    public HolyPrayer() {
        super(Rarity.RARE, Type.LEGS, EnchConfigData.NORMAL_3);
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        if (user instanceof Player player) {
            if (player.isCrouching()) {
                EntityUtils.addEct(player, MobEffects.REGENERATION, 40, level - 1);
            }
        }
    }

}
