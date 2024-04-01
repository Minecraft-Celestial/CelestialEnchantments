package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public class VoidProtection extends DefenceEnch {

	public VoidProtection() {
		super(Rarity.VERY_RARE, Type.ARMOR, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onDamaged(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypes.FELL_OUT_OF_WORLD)) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - lv * 0.08f));
		}
	}

}
