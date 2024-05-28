package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class LeopardAssimilation extends ArmorEnch implements LivingTickEnch {

	private static final EnchEffectEntry MOVE = EnchEffectEntry.amp(() -> MobEffects.MOVEMENT_SPEED, () -> 0);
	private static final EnchEffectEntry HUNGER = EnchEffectEntry.amp(() -> MobEffects.HUNGER, () -> 0, 2);

	public LeopardAssimilation() {
		super(Rarity.UNCOMMON, Type.LEGS, EnchData.bad(3, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.isSprinting()) {
			selfEffect(entity, MobEffects.MOVEMENT_SPEED, level - 1);
			selfEffect(entity, MobEffects.HUNGER, level * 2 - 1);
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, MOVE.comp(lv, alt), HUNGER.comp(lv, alt));
	}

}
