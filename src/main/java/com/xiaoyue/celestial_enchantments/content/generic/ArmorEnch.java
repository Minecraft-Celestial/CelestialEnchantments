package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.ChatFormatting;

public class ArmorEnch extends XCEnchBase {

	protected static final EnchGroup DEATH = EnchGroup.simple(ChatFormatting.LIGHT_PURPLE);
	protected static final EnchGroup EFFECT = EnchGroup.simple(ChatFormatting.GREEN);
	protected static final EnchGroup REACTIVE = EnchGroup.simple(ChatFormatting.DARK_AQUA);
	protected static final EnchGroup EXP = EnchGroup.simple(ChatFormatting.YELLOW);
	protected static final EnchGroup PROTECT = EnchGroup.simple(ChatFormatting.GOLD);

	protected ArmorEnch(Rarity rarity, Type type, EnchData config) {
		super(rarity, type, config);
	}

}
