package com.xiaoyue.celestial_enchantments.data;

import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;

public record EnchData(EnchLevel level, EnchGroup group, boolean bad) {

	public static EnchData curse(int lv) {
		return new EnchData(EnchLevel.curse(EnchType.CURSE, lv, 1), CEBaseEnchantment.CURSE, true);
	}

	public static EnchData normal(int lv, EnchGroup group) {
		return new EnchData(EnchLevel.simple(EnchType.NORMAL, lv, 10), group, false);
	}

	public static EnchData bad(int lv, EnchGroup group) {
		return new EnchData(EnchLevel.simple(EnchType.NORMAL, lv, 10), group, true);
	}

	public static EnchData treasure(int lv, EnchGroup group) {
		return new EnchData(EnchLevel.simple(EnchType.TREASURE, lv, 20), group, false);
	}

	public static EnchData special(int lv, EnchGroup group) {
		return new EnchData(EnchLevel.simple(EnchType.LEGENDARY, lv, 30), group, false);
	}

	public static EnchData specialHigh(int lv, EnchGroup group) {
		return new EnchData(EnchLevel.simple(EnchType.LEGENDARY, lv, 45), group, false);
	}
}
