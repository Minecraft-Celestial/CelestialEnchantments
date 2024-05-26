package com.xiaoyue.celestial_enchantments.content.enchantments.trident;

import com.xiaoyue.celestial_enchantments.content.generic.TridentEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExplosiveHalberd extends TridentEnch {

  private static double strength() {
		return 1;
	}

	public ExplosiveHalberd() {
		super(Rarity.VERY_RARE, EnchData.normal(5, TRIDENT));
	}

	@Override
	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
		if (trident != null && !target.level().isClientSide()) {
			if (chance(target, lv * 0.2)) {
				GeneralEventHandler.schedule(() -> target.level().explode(target,
						target.getX(), target.getY(), target.getZ(), (float) strength(), Level.ExplosionInteraction.NONE));
			}
		}
	}

}
