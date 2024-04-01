package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class ClusterAwareness extends AttackEnch {

	public ClusterAwareness() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_5);
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
