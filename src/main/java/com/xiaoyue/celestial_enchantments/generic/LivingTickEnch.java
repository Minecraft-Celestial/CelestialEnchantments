package com.xiaoyue.celestial_enchantments.generic;

import dev.xkmc.l2library.base.effects.EffectUtil;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public interface LivingTickEnch {

	void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level);

	default void selfEffect(LivingEntity entity, MobEffect eff, int lv) {
		EffectUtil.refreshEffect(entity, new MobEffectInstance(eff, 40, lv, true, true),
				EffectUtil.AddReason.SELF, entity);
	}

}
