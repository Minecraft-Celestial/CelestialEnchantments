package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public class FireproofBoots extends DefenceEnch {

  private static double damageMult() {
		return 0.85;
	}

	public FireproofBoots() {
		super(Rarity.COMMON, Type.FEET, EnchData.normal(1, EFFECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.IS_FIRE)) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - (float) damageMult()));
		}
	}

	@Override
	public boolean onAttackedImpl(LivingEntity user, AttackCache cache, int lv) {
		return getSource(cache).is(DamageTypes.HOT_FLOOR);
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(damageMult()));
	}
}
