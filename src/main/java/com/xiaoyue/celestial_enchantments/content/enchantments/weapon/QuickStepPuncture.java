package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class QuickStepPuncture extends AttackEnch {

	private static double atk() {
		return 0.16;//TODO
	}

	private static double kb() {
		return 0.3;//TODO
	}

	public QuickStepPuncture() {
		super(Rarity.RARE, EnchConfigData.NORMAL_5);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.isSprinting()) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + lv * (float) atk()));
			target.knockback(lv * kb(), user.getX() - target.getX(), user.getZ() - target.getZ());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
