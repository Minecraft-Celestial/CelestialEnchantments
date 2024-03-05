package com.xiaoyue.celestial_enchantments.generic;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHealEvent;

public interface LivingHealEnch {

	void onLivingHeal(LivingHealEvent event, LivingEntity entity, int level);

}
