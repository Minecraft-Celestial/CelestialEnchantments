package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_enchantments.content.generic.PlayerBreakEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PhotoDynamic extends ToolEnch implements PlayerBreakEnch {

	private static int light() {
		return 10;
	}

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
			if (brightness > light()) return 1 + level * (float) speed();
		}
		return 1;
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(light()), CELang.perc(lv, speed(), alt));
	}

}
