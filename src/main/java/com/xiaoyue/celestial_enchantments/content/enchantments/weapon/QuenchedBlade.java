package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class QuenchedBlade extends AttackEnch {

	public QuenchedBlade() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (target.isOnFire()) {
			float remainingFireTicks = target.getRemainingFireTicks();
			float i = remainingFireTicks * 0.01f;
			cache.addHurtModifier(DamageModifier.multTotal(1 + lv * i));
		}
	}

}
