package com.xiaoyue.celestial_enchantments.content.generic;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.util.Lazy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public record EnchGroup(boolean multi, ChatFormatting color, Supplier<Set<Enchantment>> enchs) {

	public static EnchGroup simple(ChatFormatting color) {
		return new EnchGroup(false, color, Set::of);
	}

	public static EnchGroup multi(ChatFormatting color) {
		return new EnchGroup(true, color, Set::of);
	}

	public static EnchGroup of(ChatFormatting color, Supplier<Enchantment>... enchs) {
		return new EnchGroup(false, color, Lazy.of(() -> {
			List<Enchantment> list = new ArrayList<>();
			for (var e : enchs) {
				list.add(e.get());
			}
			return new LinkedHashSet<>(list);
		}));
	}

	public boolean compatible(Enchantment other) {
		return !enchs.get().contains(other);
	}

}
