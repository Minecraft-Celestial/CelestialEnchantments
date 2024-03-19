package com.xiaoyue.celestial_enchantments.enchantments.shield;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ShieldEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class HolyShield extends ShieldEnch {

	public HolyShield() {
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
		EntityUtils.addEct(entity, MobEffects.ABSORPTION, 100, level - 1);
	}

}
