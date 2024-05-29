package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class CelestialShelter extends DefenceEnch {

  private static double def() {
		return CEModConfig.COMMON.ench.armor.celestialShelterDamageCap.get();
	}

	public CelestialShelter() {
		super(Rarity.VERY_RARE, Type.CHEST, EnchData.specialHigh(1, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		cache.addDealtModifier(DamageModifier.nonlinearPre(315, f -> Math.min(f, user.getMaxHealth() * (float) def())));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(def()));
	}

}
