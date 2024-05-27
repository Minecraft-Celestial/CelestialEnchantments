package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SuppressionBlade extends WeaponEnch {

	private static int duration() {
		return 10;//TODO
	}

	public SuppressionBlade() {
		super(Rarity.UNCOMMON, EnchData.special(3, INFLICT));
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int level) {
		if (target instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(new MobEffectInstance(CEEffects.SUPPRESSED.get(), duration() * 20));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, duration(), alt));
	}

}
