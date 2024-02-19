package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.ToolTipUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.ItemModifyEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class FleetOfFoot extends XCEnchBase implements ItemModifyEnch {
    public FleetOfFoot() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 10) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 10);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void modifyAttribute(ItemAttributeModifierEvent event, ItemStack stack, int level) {
        if (stack.getEnchantmentLevel(this) > 0) {
            if (event.getSlotType() == EquipmentSlot.FEET) {
                event.addModifier(Attributes.MOVEMENT_SPEED, new AttributeModifier(ToolTipUtils.getFUuid(), "fleet_of_foot", level * 0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
            }
        }
    }
}
