package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchGroup;
import net.minecraft.ChatFormatting;

public class GeneralEnch extends CEBaseEnchantment {

	public static final EnchGroup DURABILITY = EnchGroup.simple(CELang.GENERAL, ChatFormatting.DARK_AQUA);

	protected GeneralEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.ALL, config);
	}

}
