package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ChangeXpEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class CorruptScholar extends ArmorEnch implements ChangeXpEnch {

	public CorruptScholar() {
		super(Rarity.UNCOMMON, Type.HEAD,  EnchData.bad(3, EXP));
	}

	@Override
	public float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
		if (chance(player, 0.25 * level)) {
			var x = player.getRandom().nextDouble();
			if (x < 0.3) EntityUtils.addEct(player, MobEffects.POISON, 100, 0);
			else if (x < 0.7) EntityUtils.addEct(player, MobEffects.WITHER, 100, 0);
			else EntityUtils.addEct(player, MobEffects.WEAKNESS, 100, 0);
		}
		return level * 0.8f;
	}
}
