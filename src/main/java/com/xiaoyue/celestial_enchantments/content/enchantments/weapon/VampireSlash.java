package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class VampireSlash extends AttackEnch {

	private static double heal() {
		return CEModConfig.COMMON.ench.weapon.vampireSlashHealRate.get();
	}

	public VampireSlash() {
		super(Rarity.UNCOMMON, EnchData.treasure(5, INFLICT));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		user.heal(cache.getDamageDealt() * lv * (float) heal());
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, heal(), alt));
	}

}
