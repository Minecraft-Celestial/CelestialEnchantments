package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.ChatFormatting;

public class WeaponEnch extends XCEnchBase {

	protected static final EnchGroup INFLICT = EnchGroup.simple(ChatFormatting.GREEN);
	protected static final EnchGroup A30 = EnchGroup.simple(ChatFormatting.YELLOW);
	protected static final EnchGroup A75 = EnchGroup.simple(ChatFormatting.AQUA);
	protected static final EnchGroup A300 = EnchGroup.simple(ChatFormatting.GOLD);

	protected WeaponEnch(Rarity rarity, EnchData data) {
		super(rarity, Type.WEAPON, data);
	}

}
