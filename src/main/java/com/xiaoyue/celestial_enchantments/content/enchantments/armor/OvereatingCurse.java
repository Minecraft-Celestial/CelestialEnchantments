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

public class OvereatingCurse extends ArmorEnch implements LivingTickEnch {

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(() -> MobEffects.HUNGER, () -> 0);

	public OvereatingCurse() {
		super(Rarity.RARE, Type.CHEST, EnchData.curse(5));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		selfEffect(entity, MobEffects.HUNGER, level - 1);
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}
}
