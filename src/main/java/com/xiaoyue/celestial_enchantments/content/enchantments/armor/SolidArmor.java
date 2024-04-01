package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class SolidArmor extends DefenceEnch {

	public SolidArmor() {
		super(Rarity.VERY_RARE, Type.CHEST, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (user.getHealth() < user.getMaxHealth() / 2) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - lv * 0.03f));
		}
	}

}
