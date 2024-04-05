package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.ChatFormatting;

public class ToolEnch extends XCEnchBase {

	public static final EnchGroup TOOL = EnchGroup.multi(ChatFormatting.AQUA);

	protected ToolEnch(Rarity rarity, Type type, EnchData config) {
		super(rarity, type, config);
	}

}
