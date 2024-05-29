package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingHealEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHealEvent;

public class LifeShield extends ArmorEnch implements LivingHealEnch {

	public static double factor() {
		return CEModConfig.COMMON.ench.armor.lifeShieldPercentage.get();
	}

	public LifeShield() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchData.treasure(5, EFFECT));
	}

	@Override
	public void onLivingHeal(LivingHealEvent event, LivingEntity entity, int level) {
		float current = entity.getAbsorptionAmount();
		float max = entity.getMaxHealth() * (float) factor();
		if (current > max) return;
		float amount = event.getAmount() * (float) factor();
		entity.setAbsorptionAmount(Math.min(amount + current, max));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, factor(), alt), CELang.perc(lv, factor(), alt));
	}
}
