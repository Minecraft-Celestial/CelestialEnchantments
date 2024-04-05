package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class SolidArmor extends DefenceEnch {

	public SolidArmor() {
		super(Rarity.VERY_RARE, Type.ARMOR, EnchData.treasure(3, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (user.getHealth() < user.getMaxHealth() / 2) {
			cache.addDealtModifier(DamageModifier.multTotal(1 - lv * 0.03f));
		}
	}

}
