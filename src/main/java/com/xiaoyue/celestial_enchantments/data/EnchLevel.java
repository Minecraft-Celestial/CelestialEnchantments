package com.xiaoyue.celestial_enchantments.data;

public record EnchLevel(EnchType type, int maxLv, int baseCost, int extraCost) {

	public static EnchLevel simple(EnchType type, int max, int base) {
		return new EnchLevel(type, max, base, 30 / max);
	}

	public boolean isTreasure() {
		return true;
	}

	public boolean curse() {
		return type.curse;
	}

	public boolean discoverable() {
		return type.discoverable;
	}

	public int getMinCost(int lv) {
		return baseCost() + extraCost * (lv - 1);
	}

	public int getMaxCost(int lv) {
		return getMinCost(lv) + extraCost * 2;
	}

}
