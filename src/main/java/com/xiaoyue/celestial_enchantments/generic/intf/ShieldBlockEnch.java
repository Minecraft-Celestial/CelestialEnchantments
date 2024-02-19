package com.xiaoyue.celestial_enchantments.generic.intf;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public interface ShieldBlockEnch {

    default void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
    }
}
