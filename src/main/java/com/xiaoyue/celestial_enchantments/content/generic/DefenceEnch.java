package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

public class DefenceEnch extends ArmorEnch {

	protected DefenceEnch(Rarity rarity, Type type, EnchConfigData config) {
		super(rarity, type, config);
	}

	public boolean onAttacked(LivingEntity user, AttackCache cache, int lv) {
		return !getSource(cache).is(DamageTypeTags.BYPASSES_ENCHANTMENTS) &&
				onAttackedImpl(user, cache, lv);
	}

	protected boolean onAttackedImpl(LivingEntity user, AttackCache cache, int lv) {
		return false;
	}

	public void onDamaged(LivingEntity user, AttackCache cache, int lv) {
		if (!getSource(cache).is(DamageTypeTags.BYPASSES_ENCHANTMENTS)) {
			onDamagedImpl(user, cache, lv);
		}
	}

	protected void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {

	}

	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {

	}

}
