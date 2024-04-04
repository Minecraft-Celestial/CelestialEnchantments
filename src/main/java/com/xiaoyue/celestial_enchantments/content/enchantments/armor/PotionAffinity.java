package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2library.base.effects.EffectBuilder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class PotionAffinity extends ArmorEnch {

	public PotionAffinity() {
		super(Rarity.RARE, Type.CHEST, EnchConfigData.treasure(3), EFFECT);
	}

	public static void onAddedEffect(LivingEntity entity, int lv, MobEffectInstance ins) {
		new EffectBuilder(ins).setDuration((int) (ins.getDuration() * (1 + lv * 0.15f)));
	}
}
