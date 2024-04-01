package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;

public class BloodThirstSlash extends AttackEnch {

	public BloodThirstSlash() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_5);
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		user.heal(cache.getDamageDealt() * lv * 0.1f);
	}
}
