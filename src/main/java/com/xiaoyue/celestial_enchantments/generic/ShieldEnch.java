package com.xiaoyue.celestial_enchantments.generic;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ShieldEnch extends XCEnchBase {

	protected ShieldEnch(Rarity rarity) {
		super(rarity, Type.SHIELD);
	}

	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {

	}

}
