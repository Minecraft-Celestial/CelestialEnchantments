package com.xiaoyue.celestial_enchantments.generic.intf;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public interface PlayerBreakEnch {

    default void onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
    }
}
