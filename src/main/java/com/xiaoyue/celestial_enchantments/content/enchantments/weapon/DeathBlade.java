package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class DeathBlade extends AttackEnch {

	private static double atk() {
		return CEModConfig.COMMON.ench.weapon.deathBladeDamage.get();
	}

	public DeathBlade() {
		super(Rarity.RARE, EnchData.specialHigh(5, A300));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		float add = target.getMaxHealth() * lv * (float) atk();
		cache.addHurtModifier(DamageModifier.addExtra(add));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.percSmall(lv, atk(), alt));
	}

}
