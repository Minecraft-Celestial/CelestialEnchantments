package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.ChatFormatting;

public class GeneralEnch extends XCEnchBase {

	public static final EnchGroup DURABILITY = EnchGroup.simple(CELang.GENERAL, ChatFormatting.AQUA);

	protected GeneralEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.ALL, config);
	}

}
