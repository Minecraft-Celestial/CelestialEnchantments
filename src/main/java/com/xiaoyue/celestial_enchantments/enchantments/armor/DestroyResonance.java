package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class DestroyResonance extends ArmorEnch {
	public DestroyResonance() {
		super(Rarity.RARE, Type.HEAD);
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
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (user.getLastDamageSource() == null) return;
		List<LivingEntity> others = EntityUtils.getDelimitedMonster(user, 6 + level);
		others.remove(user);
		for (LivingEntity list : others) {
			DamageSource source = new DamageSource(user.getLastDamageSource().typeHolder());
			GeneralEventHandler.schedule(() -> list.hurt(source, level * 2));
		}
	}

}