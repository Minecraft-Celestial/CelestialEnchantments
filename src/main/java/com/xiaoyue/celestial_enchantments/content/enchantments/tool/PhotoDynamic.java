package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_enchantments.content.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PhotoDynamic extends ToolEnch implements PlayerBreakEnch {

  private static double speed() {
		return 0.12;
	}

	public PhotoDynamic() {
		super(Rarity.RARE, Type.DIGGER,  EnchData.normal(3, TOOL));
	}

	@Override
	public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
		if (player.level() instanceof ServerLevel sl) {
			int brightness = player.level().getBrightness(LightLayer.BLOCK, player.blockPosition());
			if (brightness > 10) return 1 + level * (float) speed();
		}
		return 1;
	}
}
