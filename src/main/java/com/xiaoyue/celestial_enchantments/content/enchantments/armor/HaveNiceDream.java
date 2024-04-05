package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class HaveNiceDream extends ArmorEnch {

	public HaveNiceDream() {
		super(Rarity.RARE, Type.HEAD, EnchData.normal(3, EFFECT));
	}

	public static void onPlayerWake(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.REGENERATION, 1200, lv - 1);
		EntityUtils.addEct(player, MobEffects.DIG_SPEED, 1200, lv - 1);
	}

}
