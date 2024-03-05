package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.LivingHealEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHealEvent;

public class OriginOfLife extends ArmorEnch implements LivingHealEnch {
	public OriginOfLife() {
		super(Rarity.RARE, Type.CHEST);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 24) - 1;
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
	public void onLivingHeal(LivingHealEvent event, LivingEntity entity, int level) {
		if (chance(entity, 0.5)) {
			if (chance(entity, 0.5)) {
				EntityUtils.addEct(entity, MobEffects.MOVEMENT_SPEED, 100, 0);
			} else {
				EntityUtils.addEct(entity, MobEffects.DAMAGE_RESISTANCE, 100, 0);
			}
		}
	}
}
