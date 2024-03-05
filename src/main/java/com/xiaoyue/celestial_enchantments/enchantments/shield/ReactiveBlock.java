package com.xiaoyue.celestial_enchantments.enchantments.shield;

import com.xiaoyue.celestial_enchantments.generic.ShieldEnch;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ReactiveBlock extends ShieldEnch {

	public ReactiveBlock() {
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
	public boolean isTradeable() {
		return super.isTradeable();
	}

	@Override
	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		attacker.knockback(level * 0.5f, entity.getX() - attacker.getX(), entity.getZ() - attacker.getZ());
	}

}
