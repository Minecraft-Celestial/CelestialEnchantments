package com.xiaoyue.celestial_enchantments.content.generic;

import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public interface ChangeXpEnch {

	float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb);

}
