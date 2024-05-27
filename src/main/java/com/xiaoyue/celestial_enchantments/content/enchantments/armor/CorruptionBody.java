package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CorruptionBody extends DefenceEnch {

	private static int dur() {
		return 30;
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(CEEffects.CORRUPTION::get, CorruptionBody::dur);

	public CorruptionBody() {
		super(Rarity.UNCOMMON, Type.LEGS, EnchData.normal(5, REACTIVE));
	}

	@Override
	public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			livingEntity.addEffect(EFF.ins(level));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}

}
