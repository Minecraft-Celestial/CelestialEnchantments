package com.xiaoyue.celestial_enchantments.generic.intf;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public interface LivingTickEnch {

    default void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
    }
}
