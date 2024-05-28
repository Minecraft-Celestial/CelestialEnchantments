package com.xiaoyue.celestial_enchantments.compat;

import com.xiaoyue.celestial_artifacts.CelestialArtifacts;
import com.xiaoyue.celestial_artifacts.data.CAModConfig;
import com.xiaoyue.celestial_artifacts.register.CAItems;
import com.xiaoyue.celestial_artifacts.utils.CurioUtils;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;

public class EnchCompat {

	public static int extraWeight(Player player) {
		if (ModList.get().isLoaded(CuriosApi.MODID)) {
			if (ModList.get().isLoaded(CelestialArtifacts.MODID)) {
				if (CurioUtils.hasCurio(player, CAItems.CHAOTIC_PENDANT.get())) {
					return CEModConfig.COMMON.table.chaoticPendantWeightBonus.get();
				}
			}
		}
		return 0;
	}


	public static int extraLevel(Player player) {
		if (ModList.get().isLoaded(CuriosApi.MODID)) {
			if (ModList.get().isLoaded(CelestialArtifacts.MODID)) {
				if (CurioUtils.hasCurio(player, CAItems.CHAOTIC_PENDANT.get())) {
					return CAModConfig.COMMON.pendant.chaoticPendantEnchantLevel.get();
				}
			}
		}
		return 0;
	}

}
