package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class QuenchedBlade extends AttackEnch {

	private static double atk() {
		return 0.008;//TODO
	}

	private static int maxFire() {
		return 60;//TODO
	}

	public QuenchedBlade() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (target.isOnFire()) {
			target.setSecondsOnFire(1);
			float i = Math.min(maxFire(), target.getRemainingFireTicks() * 0.05f) * (float) atk();
			cache.addHurtModifier(DamageModifier.multTotal(1 + lv * i));
			target.clearFire();
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.percSmall(lv, atk(), alt), CELang.perc(lv, atk() * maxFire(), alt));
	}
}
