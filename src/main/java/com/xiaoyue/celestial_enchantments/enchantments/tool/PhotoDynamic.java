package com.xiaoyue.celestial_enchantments.enchantments.tool;

import com.xiaoyue.celestial_enchantments.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.generic.ToolEnch;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PhotoDynamic extends ToolEnch implements PlayerBreakEnch {

	public PhotoDynamic() {
		super(Rarity.RARE, Type.DIGGER);
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
	public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
		if (player.level() instanceof ServerLevel sl) {
			int brightness = player.level().getBrightness(LightLayer.BLOCK, player.blockPosition());
			if (brightness > 10) return 1 + level * 0.12f;
		}
		return 1;
	}
}
