package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ApoptosisBlade extends WeaponEnch {

	private static int dur() {
		return 2;//TODO
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(() -> MobEffects.WITHER, ApoptosisBlade::dur);

	public ApoptosisBlade() {
		super(Rarity.UNCOMMON, EnchData.normal(3, INFLICT));
	}

	@Override
	public void doPostAttack(LivingEntity attacker, Entity target, int level) {
		if (target instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(EFF.ins(level));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}

}
