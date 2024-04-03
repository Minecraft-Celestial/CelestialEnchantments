package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttributeEnchantment;
import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.init.L2DamageTracker;
import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class DeathBlow extends WeaponEnch implements AttributeEnchantment {

	private static double crit() {
		return 0.25;//TODO
	}

	public DeathBlow() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_3, A75);
	}

	@Override
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		if (event.getSlotType() == EquipmentSlot.MAINHAND) {
			event.addModifier(L2DamageTracker.CRIT_DMG.get(), new AttributeModifier(
					MathHelper.getUUIDFromString("death_blow"),
					"death_blow", lv * crit(), AttributeModifier.Operation.ADDITION));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, crit(), alt));
	}

}
