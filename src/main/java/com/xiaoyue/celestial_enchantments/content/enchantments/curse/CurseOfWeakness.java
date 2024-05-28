package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class CurseOfWeakness extends AttackEnch {

  private static double atk() {
		return 0.15;
	}

	public CurseOfWeakness() {
		super(Rarity.UNCOMMON,  EnchData.curse(3));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		cache.addHurtModifier(DamageModifier.multTotal(1 - lv * (float) atk()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
