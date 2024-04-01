package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class QuickStepPuncture extends AttackEnch {

	public QuickStepPuncture() {
		super(Rarity.RARE, EnchConfigData.NORMAL_5);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.isSprinting()) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + (lv * 0.16f)));
			target.knockback(lv * 0.3f, user.getX() - target.getX(), user.getZ() - target.getZ());
		}
	}

}
