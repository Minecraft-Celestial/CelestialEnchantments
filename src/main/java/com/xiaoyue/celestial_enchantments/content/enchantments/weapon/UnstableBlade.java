package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class UnstableBlade extends AttackEnch {

	private static double chance() {
		return CEModConfig.COMMON.ench.weapon.unstableBladeChance.get();
	}

	private static double atk() {
		return CEModConfig.COMMON.ench.weapon.unstableBladeDamage.get();
	}

	public UnstableBlade() {
		super(Rarity.COMMON, EnchData.normal(3, A30));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.getRandom().nextDouble() < lv * chance()) {
			cache.addHurtModifier(DamageModifier.multBase(lv * (float) atk()));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, chance(), alt), CELang.perc(lv, atk(), alt));
	}
}
