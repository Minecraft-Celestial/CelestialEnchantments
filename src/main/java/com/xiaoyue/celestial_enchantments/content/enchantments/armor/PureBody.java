package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PureBody extends ArmorEnch implements LivingTickEnch {

	public PureBody() {
		super(Rarity.VERY_RARE, Type.LEGS, EnchData.specialHigh(1, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (!entity.getActiveEffects().isEmpty()) {
			entity.removeAllEffects();
		}
	}

}
