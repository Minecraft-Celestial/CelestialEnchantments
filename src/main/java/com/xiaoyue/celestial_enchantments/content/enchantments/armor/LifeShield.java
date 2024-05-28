package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.LivingHealEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHealEvent;

public class LifeShield extends ArmorEnch implements LivingHealEnch {

	public static double factor() {
		return 0.2;
	}

	public LifeShield() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchData.treasure(5, EFFECT));
	}

	@Override
	public void onLivingHeal(LivingHealEvent event, LivingEntity entity, int level) {
		float current = entity.getAbsorptionAmount();
		float max = entity.getMaxHealth() * (float) factor();
		if (current > max) return;
		float amount = event.getAmount();
		entity.setAbsorptionAmount(Math.min(amount + current, max));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, factor(), alt));
	}
}
