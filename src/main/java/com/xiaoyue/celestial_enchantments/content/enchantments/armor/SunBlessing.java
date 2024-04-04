package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class SunBlessing extends ArmorEnch implements LivingTickEnch {

	public SunBlessing() {
		super(Rarity.UNCOMMON, Type.HEAD, EnchConfigData.NORMAL_2, EFFECT);
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.level().isDay()) {
			selfEffect(entity, MobEffects.DAMAGE_BOOST, level - 1);
		}
	}

}
