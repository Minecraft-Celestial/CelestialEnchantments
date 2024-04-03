package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.ChatFormatting;

public class WeaponEnch extends XCEnchBase {

	public static EnchGroup EFFECT = new EnchGroup(ChatFormatting.GREEN);
	public static EnchGroup A30 = new EnchGroup(ChatFormatting.YELLOW);
	public static EnchGroup A75 = new EnchGroup(ChatFormatting.AQUA);
	public static EnchGroup A300 = new EnchGroup(ChatFormatting.GOLD);

	protected WeaponEnch(Rarity rarity, EnchConfigData config, EnchGroup group) {
		super(rarity, Type.WEAPON, config);
	}

}
