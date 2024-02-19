package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.register.CAttributes;
import com.xiaoyue.celestial_core.utils.ToolTipUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.ItemModifyEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class DeathBlow extends XCEnchBase implements ItemModifyEnch {
    public DeathBlow() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 6) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 6);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void modifyAttribute(ItemAttributeModifierEvent event, ItemStack stack, int level) {
        if (event.getSlotType() == EquipmentSlot.MAINHAND) {
            event.addModifier(CAttributes.CRIT_DAMAGE.get(), new AttributeModifier(ToolTipUtils.getFUuid(),
                    "death_blow", level * 0.25f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
    }
}
