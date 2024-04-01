package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class DimensionExplorer extends ArmorEnch {

	public DimensionExplorer() {
		super(Rarity.RARE, Type.FEET, EnchConfigData.NORMAL_3);
	}

	public static void onLevelChange(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.LUCK, 600, lv - 1);
		EntityUtils.addEct(player, MobEffects.DAMAGE_BOOST, 600, lv - 1);
		EntityUtils.addEct(player, MobEffects.DIG_SPEED, 600, lv - 1);
	}
}
