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

public class HeavyCurse extends ArmorEnch implements AttributeEnchantment {

	private static double slow() {
		return CEModConfig.COMMON.ench.curse.curseOfGravityAttackSpeedLost.get();
	}

	public HeavyCurse() {
		super(Rarity.RARE, Type.WEAPON, EnchData.curse(5));
	}

	@Override
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		event.addModifier(Attributes.ATTACK_SPEED, new AttributeModifier(
				MathHelper.getUUIDFromString("curse_of_gravity"), "curse_of_gravity", -lv * slow(),
				AttributeModifier.Operation.MULTIPLY_TOTAL));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, slow(), alt));
	}

}
