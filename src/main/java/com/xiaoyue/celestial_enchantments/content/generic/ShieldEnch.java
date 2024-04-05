package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ShieldEnch extends XCEnchBase {

	public static final EnchGroup SHIELD = EnchGroup.simple(ChatFormatting.AQUA);

	protected ShieldEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.SHIELD, config);
	}

	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {

	}

}
