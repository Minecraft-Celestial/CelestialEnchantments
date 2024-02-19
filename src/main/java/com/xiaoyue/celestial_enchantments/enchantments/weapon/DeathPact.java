package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.List;

public class DeathPact extends CAttackEnch {

    public DeathPact() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void onUnderDeath(LivingDeathEvent event, Entity attacker, LivingEntity entity, int level) {
        if (LevelUtils.isServerLevel(entity.level())) {
            if (entity instanceof Player player) {
                List<LivingEntity> players = EntityUtils.getExceptForCentralEntity(player, 8, 2, livingEntity -> livingEntity instanceof Player);
                for (LivingEntity list : players) {
                    int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(this, list);
                    if (enchantmentLevel > 0)
                        if (Math.random() > enchantmentLevel * 0.15) {
                            list.kill();
                        } else {
                            EntityUtils.addEct(list, MobEffects.DAMAGE_RESISTANCE, 400, 1);
                            EntityUtils.addEct(list, MobEffects.ABSORPTION, 600, 2);
                            EntityUtils.addEct(list, MobEffects.DAMAGE_BOOST, 500, 1);
                            EntityUtils.addEct(list, MobEffects.MOVEMENT_SPEED, 500, 1);
                        }
                }
            }
        }
    }
}
