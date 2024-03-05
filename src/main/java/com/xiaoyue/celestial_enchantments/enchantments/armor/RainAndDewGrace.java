package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.LivingTickEnch;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class RainAndDewGrace extends ArmorEnch implements LivingTickEnch {
	public RainAndDewGrace() {
		super(Rarity.RARE, Type.HEAD);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 10) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 10);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isTradeable() {
		return super.isTradeable();
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.tickCount % 100 == 0) {
			entity.heal(level);
		}
	}

}
