package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingTickEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;

public class DraggingCurse extends ArmorEnch implements LivingTickEnch {

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(() -> MobEffects.MOVEMENT_SLOWDOWN, () -> 0);

	public DraggingCurse() {
		super(Rarity.RARE, Type.LEGS, EnchData.curse(5));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		selfEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, level - 1);
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}
}
