package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class BurstArrow extends BowEnch {

	public BurstArrow() {
		super(Rarity.VERY_RARE, EnchConfigData.NORMAL_5);
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		if (chance(target, 0.2 * lv)) {
			GeneralEventHandler.schedule(() -> target.level().explode(arrow, arrow.getX(), arrow.getY(), arrow.getZ(), 1.0f,
					Level.ExplosionInteraction.NONE));
		}
	}

}
