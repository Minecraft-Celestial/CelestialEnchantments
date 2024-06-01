package com.xiaoyue.celestial_enchantments.content.enchantments.trident;

import com.xiaoyue.celestial_enchantments.content.generic.TridentEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExplosiveHalberd extends TridentEnch {

	private static int strength() {
		return CEModConfig.COMMON.ench.trident.explosiveHalberdExplosionLevel.get();
	}

	private static double chance() {
		return CEModConfig.COMMON.ench.trident.explosiveHalberdChance.get();
	}

	public ExplosiveHalberd() {
		super(Rarity.COMMON, EnchData.normal(5, TRIDENT));
	}

	@Override
	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
		if (trident != null && !target.level().isClientSide()) {
			if (chance(target, lv * chance())) {
				GeneralEventHandler.schedule(() -> target.level().explode(target,
						target.getX(), target.getY(), target.getZ(), strength(), Level.ExplosionInteraction.NONE));
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, chance(), alt));
	}


}
