package com.xiaoyue.celestial_enchantments.enchantments.tool;

import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PhotoDynamic extends XCEnchBase implements PlayerBreakEnch {
    public PhotoDynamic() {
        super(Rarity.RARE, IEnchUtils.TOOL, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    public void onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
        if (level > 0) {
            if (LevelUtils.isServerLevel(player.level())) {
                int brightness = player.level().getBrightness(LightLayer.BLOCK, player.blockPosition());
                if (brightness > 10) {
                    event.setNewSpeed(event.getNewSpeed() * (1 + (level * 0.12f)));
                }
            }
        }
    }
}
