package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2library.base.effects.EffectBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class PotionAffinity extends ArmorEnch {

  private static double extraTime() {
		return CEModConfig.COMMON.ench.armor.potionAffinityExtension.get();
	}

	public PotionAffinity() {
		super(Rarity.RARE, Type.LEGS, EnchData.treasure(3, EFFECT));
	}

	public static void onAddedEffect(LivingEntity entity, int lv, MobEffectInstance ins) {
		new EffectBuilder(ins).setDuration((int) (ins.getDuration() * (1 + lv * extraTime())));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, extraTime(), alt));
	}
}
