package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FrostThorns extends DefenceEnch {

	private static int dmg() {
		return CEModConfig.COMMON.ench.armor.frostThornDamage.get();
	}

	private static int dur() {
		return CEModConfig.COMMON.ench.armor.frostThornDuration.get();
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
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		if (cache.getAttacker() == null || !getSource(cache).is(L2DamageTypes.DIRECT)) return;
		DamageSource source = new DamageSource(user.damageSources().freeze().typeHolder());
		cache.getAttacker().addEffect(EFF.ins(lv));
		if (!getSource(cache).is(DamageTypeTags.AVOIDS_GUARDIAN_THORNS))
			cache.getAttacker().hurt(source, lv * dmg());
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, dmg(), alt), EFF.comp(lv, alt));
	}

}
