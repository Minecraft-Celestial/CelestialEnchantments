package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class MoonBlessing extends ArmorEnch implements LivingTickEnch {

	public MoonBlessing() {
		super(Rarity.UNCOMMON, Type.HEAD, EnchData.normal(2, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.level().isNight()) {
			selfEffect(entity, MobEffects.REGENERATION, level - 1);
		}
	}

}
