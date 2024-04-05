package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class CelestialShelter extends DefenceEnch {

	public CelestialShelter() {
		super(Rarity.VERY_RARE, Type.LEGS, EnchData.special(1, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		cache.addDealtModifier(DamageModifier.nonlinearMiddle(1015, f -> Math.min(f, user.getMaxHealth() * 0.25f)));
	}

}
