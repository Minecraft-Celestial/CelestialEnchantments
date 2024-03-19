package com.xiaoyue.celestial_enchantments.enchantments.shield;

import com.xiaoyue.celestial_enchantments.generic.ShieldEnch;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ScorchingShield extends ShieldEnch {

	public ScorchingShield() {
		super(Rarity.RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 10) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 10);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		attacker.setSecondsOnFire(level * 20);
	}

}
