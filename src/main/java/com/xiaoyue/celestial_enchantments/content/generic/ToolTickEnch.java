package com.xiaoyue.celestial_enchantments.content.generic;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

public interface ToolTickEnch {

	void onLivingTick(LivingEvent.LivingTickEvent event, ItemStack stack, int level);

}
