package com.xiaoyue.celestial_enchantments.content.generic;

import dev.xkmc.l2library.base.effects.EffectUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

public interface ToolTickEnch {

	void onLivingTick(LivingEvent.LivingTickEvent event, ItemStack entity, int level);

}
