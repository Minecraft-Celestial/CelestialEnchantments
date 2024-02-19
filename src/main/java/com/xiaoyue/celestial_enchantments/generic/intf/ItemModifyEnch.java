package com.xiaoyue.celestial_enchantments.generic.intf;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public interface ItemModifyEnch {

    default void modifyAttribute(ItemAttributeModifierEvent event, ItemStack stack, int level) {
    }
}
