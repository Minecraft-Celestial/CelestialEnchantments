package com.xiaoyue.celestial_enchantments.enchantments.tool;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.generic.GeneralEnch;
import com.xiaoyue.celestial_enchantments.generic.LivingTickEnch;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class BornInShadow extends GeneralEnch implements LivingTickEnch {

	public BornInShadow() {
		super(Rarity.VERY_RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 6) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 6);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.level().isClientSide()) return;
		if (entity.tickCount % 100 == 0) {
			if (chance(entity, level * 0.1)) {
				int brightness = CCUtils.getLight(entity.level(), entity.blockPosition());
				if (brightness < 5) {
					entity.getMainHandItem().setDamageValue(entity.getMainHandItem().getDamageValue() - 1);
				}
			}
		}
	}

}
