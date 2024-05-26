package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCurse extends DefenceEnch {

  private static double explDmg() {
		return 1.4;
	}
	
	private static double otherDmg() {
		return 1.25;
	}

	public DestructionCurse() {
		super(Rarity.UNCOMMON, Type.ARMOR, EnchData.curse(3));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		var source = getSource(cache);
		float factor = source.is(DamageTypeTags.IS_EXPLOSION) ? (float) explDmg() : (float) otherDmg();
		cache.addDealtModifier(DamageModifier.multTotal(factor * lv));
	}

}
