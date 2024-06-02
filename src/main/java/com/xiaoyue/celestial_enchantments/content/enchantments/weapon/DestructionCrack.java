package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCrack extends AttackEnch {

	private static int duration() {
		return CEModConfig.COMMON.ench.weapon.destructionCrackDuration.get();
	}

	public DestructionCrack() {
		super(Rarity.VERY_RARE, EnchData.specialHigh(3, INFLICT));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		target.addEffect(new MobEffectInstance(CEEffects.DESTRUCTED.get(), duration() * 20));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, duration(), alt));
	}

}
