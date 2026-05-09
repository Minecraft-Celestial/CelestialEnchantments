package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.content.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class MoonPower extends ToolEnch implements PlayerBreakEnch {

    private static float speed() {
        return CEModConfig.COMMON.ench.tool.moonPowerFullMoonSpeed.get().floatValue();
    }

    public MoonPower() {
        super(Rarity.UNCOMMON, Type.DIGGER, EnchData.treasure(3, TOOL));
    }

    @Override
    public float onBreakSpeed(PlayerEvent.BreakSpeed event, Player player, BlockState blockState, int level) {
        float moonFactor = CCUtils.getMoonFactor(player.level());
        return 1 + moonFactor * speed();
    }

    @Override
    public Component desc(int lv, String key, boolean alt) {
        return CELang.ench(key, CELang.perc(lv, speed(), alt));
    }
}
