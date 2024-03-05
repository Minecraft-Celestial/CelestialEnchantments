package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import dev.xkmc.l2library.base.effects.EffectBuilder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class PotionAffinity extends ArmorEnch {

	public PotionAffinity() {
		super(Rarity.RARE, Type.CHEST);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 10) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 10);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	public static void onAddedEffect(LivingEntity entity, int lv, MobEffectInstance ins) {
		new EffectBuilder(ins).setDuration((int) (ins.getDuration() * (1 + lv * 0.15f)));
	}
}
