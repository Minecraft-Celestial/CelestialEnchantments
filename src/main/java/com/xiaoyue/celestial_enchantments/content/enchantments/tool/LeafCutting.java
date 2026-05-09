package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_enchantments.content.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class LeafCutting extends ToolEnch implements PlayerBreakEnch {
    public LeafCutting() {
        super(Rarity.COMMON, Type.AXE, EnchData.normal(1, TOOL));
    }

    @Override
    public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
        if (blockState.is(BlockTags.LEAVES)) {
            return 100;
        }
        return 1;
    }
}
