package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class DivineProjection extends BowEnch {

  private static double atk() {
		return 0.03;
	}

	public DivineProjection() {
		super(Rarity.VERY_RARE, EnchData.treasure(1,ARROW));
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		var owner = arrow.getOwner();
		if (owner != null) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + owner.distanceTo(target) * (float) atk()));
		}
	}

}
