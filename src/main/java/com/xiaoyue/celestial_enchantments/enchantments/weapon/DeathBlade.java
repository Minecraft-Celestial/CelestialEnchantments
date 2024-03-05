package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.config.CommonConfig;
import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class DeathBlade extends AttackEnch {
	public DeathBlade() {
		super(Rarity.UNCOMMON);
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
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		float add = (float) Math.min(target.getMaxHealth() * 0.05, CommonConfig.DEATH_BLADE_MAX_ADD_DAMAGE.get());
		cache.addHurtModifier(DamageModifier.addExtra(add * lv));
	}
}
