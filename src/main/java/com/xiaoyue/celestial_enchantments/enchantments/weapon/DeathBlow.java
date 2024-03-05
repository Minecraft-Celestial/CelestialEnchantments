package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.AttributeEnchantment;
import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import dev.xkmc.l2damagetracker.init.L2DamageTracker;
import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.ItemAttributeModifierEvent;

public class DeathBlow extends WeaponEnch implements AttributeEnchantment {

	public DeathBlow() {
		super(Rarity.UNCOMMON);
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
	public void addAttributes(int lv, ItemAttributeModifierEvent event) {
		if (event.getSlotType() == EquipmentSlot.MAINHAND) {
			event.addModifier(L2DamageTracker.CRIT_DMG.get(), new AttributeModifier(
					MathHelper.getUUIDFromString("death_blow"),
					"death_blow", lv * 0.25f, AttributeModifier.Operation.MULTIPLY_BASE));
		}
	}
}
