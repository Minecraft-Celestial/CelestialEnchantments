package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

public class AbyssalContact extends DefenceEnch {

	private static double def() {
		return 0.06;
	}

	private static double amp() {
		return 0.12;
	}

	public AbyssalContact() {
		super(Rarity.VERY_RARE, Type.ARMOR, EnchData.bad(4, PROTECT));
	}

	@Override
	public void onDamaged(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.BYPASSES_INVULNERABILITY))
			return;
		if (getSource(cache).is(DamageTypeTags.BYPASSES_ENCHANTMENTS)) {
			cache.addDealtModifier(DamageModifier.multTotal(Math.max(0, 1 - lv * (float) def())));
		} else {
			cache.addDealtModifier(DamageModifier.multTotal(1 + lv * (float) amp()));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, def(), alt), CELang.perc(lv, amp(), alt));
	}

}
