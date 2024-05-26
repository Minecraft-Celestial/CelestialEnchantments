package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_enchantments.content.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PowerlessCurse extends ToolEnch implements PlayerBreakEnch {

  private static double speed() {
		return 0.15;
	}

	public PowerlessCurse() {
		super(Rarity.UNCOMMON, Type.DIGGER, EnchData.curse(3));
	}

	@Override
	public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
		return 1 - level * (float) speed();
	}

}
