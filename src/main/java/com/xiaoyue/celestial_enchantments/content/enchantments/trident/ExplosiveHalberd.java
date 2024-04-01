package com.xiaoyue.celestial_enchantments.content.enchantments.trident;

import com.xiaoyue.celestial_enchantments.content.generic.TridentEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExplosiveHalberd extends TridentEnch {

	public ExplosiveHalberd() {
		super(Rarity.VERY_RARE, EnchConfigData.NORMAL_5);
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
