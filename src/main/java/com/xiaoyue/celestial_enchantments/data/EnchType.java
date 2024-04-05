package com.xiaoyue.celestial_enchantments.data;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;

import java.util.function.Supplier;

public enum EnchType {
	CURSE(true, true, () -> CELang.CURSE.get().withStyle(ChatFormatting.RED)),
	NORMAL(false, true, () -> CELang.NORMAL.get().withStyle(ChatFormatting.GREEN)),
	TREASURE(false, false, () -> CELang.ADVANCED.get().withStyle(ChatFormatting.AQUA)),
	LEGENDARY(false, false, () -> CELang.LEGENDARY.get().withStyle(ChatFormatting.GOLD)),
	;

	public final boolean curse, discoverable;
	public final Supplier<MutableComponent> lang;


	EnchType(boolean curse, boolean discoverable, Supplier<MutableComponent> lang) {
		this.curse = curse;
		this.discoverable = discoverable;
		this.lang = lang;
	}

}
