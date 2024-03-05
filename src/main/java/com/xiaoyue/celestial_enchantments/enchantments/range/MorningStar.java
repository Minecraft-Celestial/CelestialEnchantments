package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.BowEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class MorningStar extends BowEnch {
	public MorningStar() {
		super(Rarity.RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 10) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 10);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.FLAMING_ARROWS;
	}

	@Override
	public boolean isTradeable() {
		return super.isTradeable();
	}

	@Override
	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		if (chance(target, 1 - Math.pow(0.5, lv))) {
			GeneralEventHandler.schedule(() -> EntityUtils.spawnThunder(target));
		}
	}

}