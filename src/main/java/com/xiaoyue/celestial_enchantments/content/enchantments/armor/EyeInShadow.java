package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EyeInShadow extends ArmorEnch implements LivingTickEnch {

	public EyeInShadow() {
		super(Rarity.VERY_RARE, Type.HEAD, EnchConfigData.NORMAL_1, EFFECT);
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int lv) {
		if (entity.level() instanceof ServerLevel sl) {
			int light = CCUtils.getLight(sl, entity.blockPosition());
			if (light < 5) {
				selfEffect(entity, MobEffects.NIGHT_VISION, 0);
			}
		}
	}

}
