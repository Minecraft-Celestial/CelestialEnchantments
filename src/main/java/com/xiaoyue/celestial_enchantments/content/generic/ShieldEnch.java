package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ShieldEnch extends XCEnchBase {

	protected ShieldEnch(Rarity rarity, EnchConfigData config) {
		super(rarity, Type.SHIELD, config);
	}

	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {

	}

}
