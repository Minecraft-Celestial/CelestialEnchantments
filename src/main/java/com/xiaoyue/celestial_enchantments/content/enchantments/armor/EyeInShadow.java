package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EyeInShadow extends ArmorEnch implements LivingTickEnch {

	private static int light() {
		return CEModConfig.COMMON.ench.armor.eyesInShadowsMaxLight.get();
	}


	public EyeInShadow() {
		super(Rarity.VERY_RARE, Type.HEAD, EnchData.normal(1, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int lv) {
		if (entity.level() instanceof ServerLevel sl) {
			int light = CCUtils.getLight(sl, entity.blockPosition());
			if (light <= light()) {
				selfEffect(entity, MobEffects.NIGHT_VISION, 0);
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(light()), CELang.eff(MobEffects.NIGHT_VISION));
	}
}
