package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.AttributeEnchantment;
import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class FleetOfFoot extends ArmorEnch implements AttributeEnchantment {

	public FleetOfFoot() {
		super(Rarity.RARE, Type.FEET);
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
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		event.addModifier(Attributes.MOVEMENT_SPEED, new AttributeModifier(
				MathHelper.getUUIDFromString("fleet_of_foot"), "fleet_of_foot", lv * 0.1f,
				AttributeModifier.Operation.MULTIPLY_BASE));
	}

}
