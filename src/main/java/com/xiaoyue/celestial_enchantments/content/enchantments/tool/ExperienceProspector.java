package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.level.BlockEvent;

public class ExperienceProspector extends ToolEnch {

    private static double chance() {
        return CEModConfig.COMMON.ench.tool.experienceProspectorChance.get();
    }

    private static int exp() {
        return CEModConfig.COMMON.ench.tool.experienceProspectorExp.get();
    }

    public ExperienceProspector() {
        super(Rarity.VERY_RARE, Type.DIGGER , EnchData.specialHigh(4, TOOL));
    }

    public static void onBlockBreak(Player player, BlockEvent.BreakEvent event, int lv) {
        if (player.getRandom().nextDouble() <= chance() * lv) {
            event.setExpToDrop(event.getExpToDrop() + exp() * lv);
        }
    }

    @Override
    public Component desc(int lv, String key, boolean alt) {
        return CELang.ench(key, CELang.perc(lv, chance(), alt), CELang.num(lv, exp(), alt));
    }
}
