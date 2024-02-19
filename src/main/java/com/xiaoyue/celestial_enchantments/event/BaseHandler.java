package com.xiaoyue.celestial_enchantments.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BaseHandler {

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getPersistentData().getBoolean("destruction_crack")) {
            if (entity.invulnerableTime > 1) {
                entity.invulnerableTime = 0;
                entity.setInvulnerable(false);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHeal(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getPersistentData().getBoolean("suppression_blade")) {
            event.setCanceled(true);
        }
    }
}
