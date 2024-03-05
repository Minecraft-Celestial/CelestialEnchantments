package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.LivingTickEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class SunBlessing extends ArmorEnch implements LivingTickEnch {

	public SunBlessing() {
		super(Rarity.UNCOMMON, Type.HEAD);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 15) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 15);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.level().isDay()) {
			selfEffect(entity, MobEffects.DAMAGE_BOOST, level - 1);
		}
	}

}
