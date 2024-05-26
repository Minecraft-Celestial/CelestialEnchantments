package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchGroup;
import net.minecraft.ChatFormatting;

public class ToolEnch extends CEBaseEnchantment {

	public static final EnchGroup TOOL = EnchGroup.multi(CELang.UTILITY, ChatFormatting.GRAY);

	protected ToolEnch(Rarity rarity, Type type, EnchData config) {
		super(rarity, type, config);
	}

}
