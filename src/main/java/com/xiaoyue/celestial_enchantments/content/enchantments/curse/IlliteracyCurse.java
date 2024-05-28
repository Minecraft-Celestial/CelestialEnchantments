package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ChangeXpEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class IlliteracyCurse extends ArmorEnch implements ChangeXpEnch {

	private static double exp() {
		return CEModConfig.COMMON.ench.curse.curseOfIlliteracyExpLost.get();
	}

	public IlliteracyCurse() {
		super(Rarity.UNCOMMON, Type.HEAD, EnchData.curse(3));
	}

	@Override
	public float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
		return -level * (float) exp();
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, exp(), alt));
	}

}
