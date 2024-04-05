package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.ChatFormatting;

public class GeneralEnch extends XCEnchBase {

	public static final EnchGroup DURABILITY = EnchGroup.simple(ChatFormatting.AQUA);

	protected GeneralEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.ALL, config);
	}

}
