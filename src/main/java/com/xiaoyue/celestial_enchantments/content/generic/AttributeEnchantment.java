package com.xiaoyue.celestial_enchantments.content.generic;

import net.minecraftforge.event.ItemAttributeModifierEvent;

public interface AttributeEnchantment {

	void addAttributes(int lv, ItemAttributeModifierEvent event);

}
