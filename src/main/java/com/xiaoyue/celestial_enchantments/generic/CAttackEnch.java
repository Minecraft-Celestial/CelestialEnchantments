package com.xiaoyue.celestial_enchantments.generic;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class CAttackEnch extends XCEnchBase {
    protected CAttackEnch(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots);
    }

    public void onUnderAttack(LivingAttackEvent event, LivingEntity entity, int level) {
    }

    public void onUnderHurt(LivingHurtEvent event, Entity attacker, LivingEntity entity, int level) {
    }

    public void onUnderDamage(LivingDamageEvent event, Entity attacker, LivingEntity entity, int level) {
    }

    public void onUnderDeath(LivingDeathEvent event, Entity attacker, LivingEntity entity, int level) {
    }

    public void onAttackEntity(LivingAttackEvent event, LivingEntity attacker, LivingEntity target, int level) {
    }

    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
    }

    public void onDamageEntity(LivingDamageEvent event, LivingEntity attacker, LivingEntity target, int level) {
    }

    public void onKillEntity(LivingDeathEvent event, LivingEntity attacker, LivingEntity target, int level) {
    }
}
