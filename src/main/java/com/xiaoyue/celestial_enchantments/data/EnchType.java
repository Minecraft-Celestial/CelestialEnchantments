package com.xiaoyue.celestial_enchantments.data;

public enum EnchType {
	CURSE(true, true),
	NORMAL(false, true),
	TREASURE(false, false),
	LEGENDARY(false, false);

	public final boolean curse, discoverable;


	EnchType(boolean curse, boolean discoverable) {
		this.curse = curse;
		this.discoverable = discoverable;
	}
}
