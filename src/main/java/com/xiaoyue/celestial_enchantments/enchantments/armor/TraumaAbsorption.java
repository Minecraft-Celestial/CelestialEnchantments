package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;

public class TraumaAbsorption extends DefenceEnch {

	public TraumaAbsorption() {
		super(Rarity.RARE, Type.CHEST);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 15) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 15);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		user.heal((user.getMaxHealth() - user.getHealth()) * 0.09f);
	}

}
