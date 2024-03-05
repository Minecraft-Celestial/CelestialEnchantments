package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DestructionCurse extends DefenceEnch {
	public DestructionCurse() {
		super(Rarity.UNCOMMON, Type.CHEST);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 22) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 28);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		var source = getSource(cache);
		float factor = source.is(DamageTypeTags.IS_EXPLOSION) ? 1.4f : 1.25f;
		cache.addDealtModifier(DamageModifier.multTotal(factor));
	}

}
