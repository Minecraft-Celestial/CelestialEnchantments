package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class SharpArrow extends BowEnch {

  private static double atk() {
		return 0.2;
	}

	public SharpArrow() {
		super(Rarity.VERY_RARE, EnchData.normal(3, ARROW));
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		cache.addHurtModifier(DamageModifier.multTotal(1 + lv * (float) atk()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
