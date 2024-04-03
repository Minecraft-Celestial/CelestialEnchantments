package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class HiddenBlade extends AttackEnch {

	private static double atk() {
		return 0.1;//TODO
	}

	public HiddenBlade() {
		super(Rarity.RARE, EnchConfigData.NORMAL_3, A30);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user.hasEffect(MobEffects.INVISIBILITY))
			cache.addHurtModifier(DamageModifier.multBase(lv * (float) atk()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.eff(MobEffects.INVISIBILITY),
				CELang.perc(lv, atk(), alt));
	}

}
