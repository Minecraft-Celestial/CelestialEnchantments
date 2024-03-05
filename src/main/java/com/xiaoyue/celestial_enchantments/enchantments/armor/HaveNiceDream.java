package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class HaveNiceDream extends ArmorEnch {

	public HaveNiceDream() {
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

	public static void onPlayerWake(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.REGENERATION, 200, lv - 1);
		EntityUtils.addEct(player, MobEffects.JUMP, 200, lv - 1);
	}

}
