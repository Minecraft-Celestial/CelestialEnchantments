package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class DimensionExplorer extends ArmorEnch {

	public DimensionExplorer() {
		super(Rarity.RARE, Type.FEET);
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

	public static void onLevelChange(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.LUCK, 600, lv - 1);
		EntityUtils.addEct(player, MobEffects.DAMAGE_BOOST, 600, lv - 1);
		EntityUtils.addEct(player, MobEffects.DIG_SPEED, 600, lv - 1);
	}
}
