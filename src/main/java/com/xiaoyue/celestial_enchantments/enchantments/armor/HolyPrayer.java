package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class HolyPrayer extends ArmorEnch {
    public HolyPrayer() {
        super(Rarity.RARE, Type.LEGS);
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
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        if (user instanceof Player player) {
            if (player.isCrouching()) {
                EntityUtils.addEct(player, MobEffects.REGENERATION, 40, level - 1);
            }
        }
    }

}
