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

public class TurtleAssimilation extends ArmorEnch implements LivingTickEnch {

	private static final EnchEffectEntry MOVE = EnchEffectEntry.amp(() -> MobEffects.MOVEMENT_SLOWDOWN, () -> 0, 2);
	private static final EnchEffectEntry RES = EnchEffectEntry.amp(() -> MobEffects.DAMAGE_RESISTANCE, () -> 0);

	public TurtleAssimilation() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchData.bad(3, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.isShiftKeyDown()) {
			selfEffect(entity, MobEffects.DAMAGE_RESISTANCE, level - 1);
			selfEffect(entity, MobEffects.MOVEMENT_SLOWDOWN, level * 2 - 1);
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, RES.comp(lv, alt), MOVE.comp(lv, alt));
	}

}
