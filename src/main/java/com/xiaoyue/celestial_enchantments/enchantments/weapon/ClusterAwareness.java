package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ClusterAwareness extends AttackEnch {
	public ClusterAwareness() {
		super(Rarity.UNCOMMON);
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
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user instanceof Monster monster) {
			List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(monster, 6, 2, livingEntity -> livingEntity instanceof Monster);
			cache.addHurtModifier(DamageModifier.add(lv * 0.12f * entities.size()));
		}
		if (user instanceof Player player) {
			List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(player, 6, 2, livingEntity -> livingEntity instanceof Player);
			cache.addHurtModifier(DamageModifier.add(lv * 0.12f * entities.size()));
		}
	}

}
