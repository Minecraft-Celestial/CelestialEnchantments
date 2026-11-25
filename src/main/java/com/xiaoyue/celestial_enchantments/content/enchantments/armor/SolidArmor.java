package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.DamageData;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class SolidArmor extends DefenceEnch {

  private static double def() {
		return CEModConfig.SERVER.ench.armor.solidArmorReduction.get();
	}

	public SolidArmor() {
		super(Rarity.UNCOMMON, Type.ARMOR, EnchData.treasure(4, PROTECT));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, DamageData.Defence data, int lv) {
		if (user.getHealth() < user.getMaxHealth() / 2) {
			data.addDealtModifier(DamageModifier.multTotal(Math.max(0, 1 - lv * (float) def()), damageId()));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, def(), alt));
	}


}
