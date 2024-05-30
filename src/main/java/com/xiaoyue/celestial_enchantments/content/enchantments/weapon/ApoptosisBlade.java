package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ApoptosisBlade extends AttackEnch {

	private static int dur() {
		return CEModConfig.COMMON.ench.weapon.apoptosisBladeWitherDuration.get();
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.amp(() -> MobEffects.WITHER, ApoptosisBlade::dur);

	public ApoptosisBlade() {
		super(Rarity.UNCOMMON, EnchData.normal(3, INFLICT));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		target.addEffect(EFF.ins(lv));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}

}
