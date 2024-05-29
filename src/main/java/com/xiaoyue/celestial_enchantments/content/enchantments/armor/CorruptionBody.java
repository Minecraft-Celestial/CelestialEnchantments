package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class CorruptionBody extends DefenceEnch {

	private static int dur() {
		return CEModConfig.COMMON.ench.armor.corruptionBodyDuration.get();
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(CEEffects.CORRUPTION::get, CorruptionBody::dur);

	public CorruptionBody() {
		super(Rarity.UNCOMMON, Type.LEGS, EnchData.normal(5, REACTIVE));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		if (cache.getAttacker() == null || !getSource(cache).is(L2DamageTypes.DIRECT)) return;
		cache.getAttacker().addEffect(EFF.ins(lv));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}

}
