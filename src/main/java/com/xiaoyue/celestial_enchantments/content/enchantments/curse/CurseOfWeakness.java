package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.DamageData;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class CurseOfWeakness extends AttackEnch {

  private static double atk() {
	  return CEModConfig.SERVER.ench.curse.curseOfWeaknessAttackLost.get();
	}

	public CurseOfWeakness() {
		super(Rarity.UNCOMMON,  EnchData.curse(5));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, DamageData.Offence data, int lv) {
		data.addHurtModifier(DamageModifier.multTotal(Math.max(0, 1 - lv * (float) atk()), damageId()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
