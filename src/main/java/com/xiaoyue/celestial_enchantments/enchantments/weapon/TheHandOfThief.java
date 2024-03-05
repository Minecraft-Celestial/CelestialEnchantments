package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class TheHandOfThief extends AttackEnch {

	public TheHandOfThief() {
		super(Rarity.VERY_RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 6) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 6);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public void onKillEntity(LivingDeathEvent event, LivingEntity attacker, LivingEntity target, int level) {
		if (level > 0) {
			if (target instanceof Mob mob) {
				for (EquipmentSlot value : EquipmentSlot.values()) {
					mob.setDropChance(value, 1);
				}
			}
		}
	}

}
