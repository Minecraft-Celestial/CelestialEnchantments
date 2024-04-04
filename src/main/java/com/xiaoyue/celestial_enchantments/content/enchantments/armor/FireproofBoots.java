package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public class FireproofBoots extends DefenceEnch {

	public FireproofBoots() {
		super(Rarity.UNCOMMON, Type.FEET, EnchConfigData.NORMAL_1, EFFECT);
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.IS_FIRE)) {
			cache.addDealtModifier(DamageModifier.multTotal(0.85f));
		}
	}

	@Override
	public boolean onAttackedImpl(LivingEntity user, AttackCache cache, int lv) {
		return getSource(cache).is(DamageTypes.HOT_FLOOR);
	}

}
