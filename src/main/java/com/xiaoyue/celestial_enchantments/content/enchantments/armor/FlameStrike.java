package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FlameStrike extends DefenceEnch {

  private static int fireTime() {
	  return CEModConfig.COMMON.ench.armor.flameStrikeDuration.get();
	}

	public FlameStrike() {
		super(Rarity.RARE, Type.ARMOR, EnchData.normal(5, REACTIVE));
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.THORNS;
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		if (cache.getAttacker() == null || !getSource(cache).is(L2DamageTypes.DIRECT)) return;
		cache.getAttacker().setSecondsOnFire(lv * fireTime());
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, fireTime(), alt));
	}


}
