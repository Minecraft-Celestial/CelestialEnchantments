package com.xiaoyue.celestial_enchantments.data;

public record EnchConfigData(boolean curse, boolean treasure, boolean tradeable, boolean discoverable, int maxLv,
							 int baseCost, int extraCost) {

	private static EnchConfigData simple(boolean curse, boolean treasure, boolean tradeable, int max) {
		return new EnchConfigData(curse, treasure, tradeable, true, max, 1, 30 / max);
	}

	public static EnchConfigData curse(int max) {
		return simple(true, true, true, max);
	}

	public static EnchConfigData treasure(int max) {
		return simple(false, true, true, max);
	}

	public static EnchConfigData special(int max) {
		return simple(false, true, false, max);
	}

	public static EnchConfigData normal(int max) {
		return simple(false, false, true, max);
	}

	public static EnchConfigData NORMAL_1 = normal(1);
	public static EnchConfigData NORMAL_2 = normal(2);
	public static EnchConfigData NORMAL_3 = normal(3);
	public static EnchConfigData NORMAL_5 = normal(5);


	public boolean isTreasure() {
		return curse || treasure;
	}

	public int getMinCost(int lv) {
		return baseCost() + extraCost * (lv - 1);
	}

	public int getMaxCost(int lv) {
		return getMinCost(lv) + extraCost * 2;
	}

}
