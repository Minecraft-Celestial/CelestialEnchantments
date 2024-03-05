package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_enchantments.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.generic.ChangeXpEnch;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class KnowledgeScholar extends ArmorEnch implements ChangeXpEnch {

	public KnowledgeScholar() {
		super(Rarity.UNCOMMON, Type.HEAD);
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

	@Override
	public float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
		return level * 0.1f;
	}

}
