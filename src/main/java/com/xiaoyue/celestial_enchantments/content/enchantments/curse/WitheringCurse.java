package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.AttributeEnchantment;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class WitheringCurse extends ArmorEnch implements AttributeEnchantment {

	private static double health() {
		return CEModConfig.COMMON.ench.curse.curseOfWitheringHealthLost.get();
	}

	public WitheringCurse() {
		super(Rarity.RARE, Type.ARMOR, EnchData.curse(4));
	}

	@Override
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		event.addModifier(Attributes.MAX_HEALTH, new AttributeModifier(
				MathHelper.getUUIDFromString("curse_of_withering"), "curse_of_withering", -lv * health(),
				AttributeModifier.Operation.MULTIPLY_BASE));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, health(), alt));
	}

}
