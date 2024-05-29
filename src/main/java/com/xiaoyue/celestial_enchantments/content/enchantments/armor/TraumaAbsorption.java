package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class TraumaAbsorption extends DefenceEnch {

  private static double heal() {
	  return CEModConfig.COMMON.ench.armor.traumaAbsorptionHeal.get();
	}

	public TraumaAbsorption() {
		super(Rarity.UNCOMMON, Type.ARMOR, EnchData.special(5, PROTECT));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		user.heal((user.getMaxHealth() - user.getHealth()) * (float) heal());
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, heal(), alt));
	}

}
