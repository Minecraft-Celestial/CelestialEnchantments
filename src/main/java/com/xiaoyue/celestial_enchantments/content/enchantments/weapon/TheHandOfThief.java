package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class TheHandOfThief extends AttackEnch {

	public TheHandOfThief() {
		super(Rarity.VERY_RARE, EnchData.treasure(1, INFLICT));
	}

	@Override
	public void onKillEntity(LivingDeathEvent event, LivingEntity attacker, LivingEntity target, int level) {
		if (target instanceof Mob mob) {
			for (EquipmentSlot value : EquipmentSlot.values()) {
				mob.setDropChance(value, 1);
			}
		}
	}

}
