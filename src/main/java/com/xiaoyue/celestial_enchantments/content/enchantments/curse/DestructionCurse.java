package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCurse extends DefenceEnch {

	private static double explDmg() {
		return CEModConfig.COMMON.ench.curse.destructionCurseExplosion.get();
	}
	
	private static double otherDmg() {
		return CEModConfig.COMMON.ench.curse.destructionCurseOther.get();
	}

	public DestructionCurse() {
		super(Rarity.UNCOMMON, Type.ARMOR, EnchData.curse(3));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		var source = getSource(cache);
		float factor = source.is(DamageTypeTags.IS_EXPLOSION) ? (float) explDmg() : (float) otherDmg();
		cache.addDealtModifier(DamageModifier.multTotal(1 + factor * lv));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, explDmg(), alt), CELang.perc(lv, otherDmg(), alt));
	}

}
