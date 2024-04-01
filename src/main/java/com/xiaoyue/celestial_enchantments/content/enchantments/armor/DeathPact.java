package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DeathEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.List;

public class DeathPact extends DeathEnch {

	public DeathPact() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchConfigData.treasure(5));
	}

	@Override
	public void onDeath(LivingEntity entity, int ignored) {
		if (entity.level().isClientSide()) return;
		if (entity instanceof Player player) {
			List<LivingEntity> list = EntityUtils.getExceptForCentralEntity(player, 8, 2, livingEntity -> livingEntity instanceof Player);
			for (LivingEntity pl : list) {
				int lv = EnchantmentHelper.getEnchantmentLevel(this, pl);
				if (chance(entity, lv * 0.15)) {
					pl.kill();
				} else {
					EntityUtils.addEct(pl, MobEffects.DAMAGE_RESISTANCE, 400, 1);
					EntityUtils.addEct(pl, MobEffects.ABSORPTION, 600, 2);
					EntityUtils.addEct(pl, MobEffects.DAMAGE_BOOST, 500, 1);
					EntityUtils.addEct(pl, MobEffects.MOVEMENT_SPEED, 500, 1);
				}
			}
		}
	}

}
