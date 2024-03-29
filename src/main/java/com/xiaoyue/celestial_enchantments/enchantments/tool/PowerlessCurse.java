package com.xiaoyue.celestial_enchantments.enchantments.tool;

import com.xiaoyue.celestial_enchantments.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.generic.ToolEnch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PowerlessCurse extends ToolEnch implements PlayerBreakEnch {

	public PowerlessCurse() {
		super(Rarity.UNCOMMON, Type.DIGGER);
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
	public boolean isCurse() {
		return true;
	}

	@Override
	public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
		return 1 - level * 0.15f;
	}

}
