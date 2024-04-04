package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class HaveNiceDream extends ArmorEnch {

	public HaveNiceDream() {
		super(Rarity.RARE, Type.HEAD, EnchConfigData.NORMAL_3, EFFECT);
	}

	public static void onPlayerWake(Player player, int lv) {
		EntityUtils.addEct(player, MobEffects.REGENERATION, 200, lv - 1);
		EntityUtils.addEct(player, MobEffects.JUMP, 200, lv - 1);
	}

}
