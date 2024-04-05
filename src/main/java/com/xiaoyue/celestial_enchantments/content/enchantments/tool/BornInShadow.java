package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.content.generic.GeneralEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class BornInShadow extends GeneralEnch implements LivingTickEnch {

	public BornInShadow() {
		super(Rarity.VERY_RARE, EnchData.normal(5, DURABILITY));
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
