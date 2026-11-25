package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.AttributeEnchantment;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

public class WitheringCurse extends ArmorEnch implements AttributeEnchantment {

	private static double health() {
		return CEModConfig.SERVER.ench.curse.curseOfWitheringHealthLost.get();
	}

	public WitheringCurse() {
		super(Rarity.RARE, Type.ARMOR, EnchData.curse(4));
	}

	@Override
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		double lost = Math.min(0.9, lv * health());
		event.addModifier(Attributes.MAX_HEALTH, new AttributeModifier(
				CelestialEnchantments.loc("curse_of_withering"), -lost,
				AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, health(), alt));
	}

}
