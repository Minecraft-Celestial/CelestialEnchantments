package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DeathEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class PartingWish extends DeathEnch {

	private static int radius() {
		return 12;
	}

	private static int heal() {
		return 8;
	}

	public PartingWish() {
		super(Rarity.UNCOMMON, Type.HEAD, EnchData.normal(3, DEATH));
	}

	@Override
	public void onDeath(LivingEntity entity, int level) {
		if (!(entity instanceof Player)) return;
		List<LivingEntity> players = EntityUtils.getExceptForCentralEntity(entity, radius(), 2, livingEntity -> livingEntity instanceof Player);
		for (LivingEntity list : players) {
			list.heal(level * (float) heal());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, heal(), alt));
	}

}
