package com.xiaoyue.celestial_enchantments.enchantments.trident;

import com.xiaoyue.celestial_enchantments.generic.TridentEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExplosiveHalberd extends TridentEnch {

	public ExplosiveHalberd() {
		super(Rarity.VERY_RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 6) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 6);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
		if (trident != null && !target.level().isClientSide()) {
			if (chance(target, lv * 0.2)) {
				GeneralEventHandler.schedule(() -> target.level().explode(target,
						target.getX(), target.getY(), target.getZ(), 1.0f, Level.ExplosionInteraction.NONE));
			}
		}
	}
}
