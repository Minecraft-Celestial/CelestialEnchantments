package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

public class DestructionCurse extends DefenceEnch {

	public DestructionCurse() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchConfigData.curse(1));
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		var source = getSource(cache);
		float factor = source.is(DamageTypeTags.IS_EXPLOSION) ? 1.4f : 1.25f;
		cache.addDealtModifier(DamageModifier.multTotal(factor));
	}

}
