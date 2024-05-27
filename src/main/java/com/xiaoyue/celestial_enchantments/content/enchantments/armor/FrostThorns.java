package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FrostThorns extends ArmorEnch {

	private static int dmg() {
		return 1;
	}

	private static int dur() {
		return 2;
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.all(() -> MobEffects.MOVEMENT_SLOWDOWN, FrostThorns::dur);

	public FrostThorns() {
		super(Rarity.RARE, Type.ARMOR, EnchData.treasure(5, REACTIVE));
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.THORNS;
	}

	@Override
	public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			DamageSource source = new DamageSource(entity.damageSources().freeze().typeHolder());
			livingEntity.hurt(source, level * dmg());
			livingEntity.addEffect(EFF.ins(level));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, dmg(), alt), EFF.comp(lv, alt));
	}

}
