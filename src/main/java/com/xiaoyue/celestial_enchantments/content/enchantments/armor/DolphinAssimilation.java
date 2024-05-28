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

public class DolphinAssimilation extends ArmorEnch implements LivingTickEnch {

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(() -> MobEffects.DOLPHINS_GRACE, () -> 1);

	public DolphinAssimilation() {
		super(Rarity.RARE, Type.LEGS, EnchData.normal(1, EFFECT));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, LivingEntity entity, int level) {
		if (entity.isInWaterOrRain()) {
			selfEffect(entity, MobEffects.DOLPHINS_GRACE, 0);
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.eff(MobEffects.DOLPHINS_GRACE));
	}

}
