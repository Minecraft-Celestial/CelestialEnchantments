package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class DimensionExplorer extends ArmorEnch {

	public DimensionExplorer() {
		super(Rarity.RARE, Type.FEET, EnchData.normal(3, EFFECT));
	}

	public static void onLevelChange(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.LUCK, 1200, lv - 1);
		EntityUtils.addEct(player, MobEffects.DAMAGE_BOOST, 1200, lv - 1);
		EntityUtils.addEct(player, MobEffects.DIG_SPEED, 1200, lv - 1);
	}
}
