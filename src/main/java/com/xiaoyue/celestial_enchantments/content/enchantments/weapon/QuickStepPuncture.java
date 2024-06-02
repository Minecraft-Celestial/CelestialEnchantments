package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class QuickStepPuncture extends AttackEnch {

	private static double atk() {
		return CEModConfig.COMMON.ench.weapon.quickStepPunctureDamage.get();
	}

	private static double kb() {
		return CEModConfig.COMMON.ench.weapon.quickStepPunctureKnockback.get();
	}

	public QuickStepPuncture() {
		super(Rarity.UNCOMMON, EnchData.treasure(5, A75));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.isSprinting()) {
			cache.addHurtModifier(DamageModifier.multBase(lv * (float) atk()));
			target.knockback(lv * kb(), user.getX() - target.getX(), user.getZ() - target.getZ());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
