package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.entity.LivingEntity;

public class DeathEnch extends ArmorEnch {

	protected DeathEnch(Rarity rarity, Type type, EnchData config) {
		super(rarity, type, config);
	}

	public void onDeath(LivingEntity entity, int lv) {

	}

}
