package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class RainAndDewGrace extends ArmorEnch implements LivingTickEnch {

  private static int time() {
		return 100;
	}

	public RainAndDewGrace() {
		super(Rarity.RARE, Type.HEAD, EnchData.normal(3, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.isInWaterOrRain() && entity.tickCount % time() == 0) {
			entity.heal(level);
		}
	}

}
