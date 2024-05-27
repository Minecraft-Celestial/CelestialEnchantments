package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCrack extends WeaponEnch {

	private static int duration() {
		return 5;//TODO
	}

	public DestructionCrack() {
		super(Rarity.VERY_RARE, EnchData.specialHigh(3, INFLICT));
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.DESTRUCTED.get(), duration() * 20));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, duration(), alt));
	}

}
