package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.AttributeEnchantment;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class FleetOfFoot extends ArmorEnch implements AttributeEnchantment {

  private static double speed() {
		return 0.1;
	}

	public FleetOfFoot() {
		super(Rarity.RARE, Type.FEET, EnchData.treasure(3, EFFECT));
	}

	@Override
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		event.addModifier(Attributes.MOVEMENT_SPEED, new AttributeModifier(
				MathHelper.getUUIDFromString("fleet_of_foot"), "fleet_of_foot", lv * speed(),
				AttributeModifier.Operation.MULTIPLY_BASE));
	}

}
