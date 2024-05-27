package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ChangeXpEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class CorruptScholar extends ArmorEnch implements ChangeXpEnch {

	private static double exp() {
		return 0.8;
	}

	private static double chance() {
		return 0.25;
	}

	private static int dur() {
		return 5;
	}

	public CorruptScholar() {
		super(Rarity.UNCOMMON, Type.HEAD,  EnchData.bad(3, EXP));
	}

	@Override
	public float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
		if (chance(player, chance() * level)) {
			var x = player.getRandom().nextDouble();
			if (x < 0.3) EntityUtils.addEct(player, MobEffects.POISON, dur() * 20, 0);
			else if (x < 0.7) EntityUtils.addEct(player, MobEffects.WITHER, dur() * 20, 0);
			else EntityUtils.addEct(player, MobEffects.WEAKNESS, dur() * 20, 0);
		}
		return level * (float) exp();
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, exp(), alt), CELang.perc(lv, chance(), alt));
	}

}
