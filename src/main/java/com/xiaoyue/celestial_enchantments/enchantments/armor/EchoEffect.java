package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EchoEffect extends CAttackEnch {
    public EchoEffect() {
        super(Rarity.VERY_RARE, EnchantmentCategory.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
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

    @Override
    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            if (event.getAmount() > entity.getHealth()) {
                ItemStack item = entity.getItemBySlot(EquipmentSlot.CHEST);
                if (entity instanceof Player player) {
                    if (player.getCooldowns().isOnCooldown(item.getItem())) return;
                    event.setCanceled(true);
                    entity.heal(entity.getMaxHealth() * (level * 0.05f));
                    player.getCooldowns().addCooldown(item.getItem(), 1200);
                }
            }
        }
    }
}
