package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class GiftOfThunderGod extends DefenceEnch {
	public GiftOfThunderGod() {
		super(Rarity.UNCOMMON, Type.CHEST);
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
	public void onDamagedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.IS_LIGHTNING)) {
			user.heal(user.getMaxHealth() - user.getHealth());
			EntityUtils.addEct(user, MobEffects.MOVEMENT_SPEED, 200, lv - 1);
			EntityUtils.addEct(user, MobEffects.DAMAGE_RESISTANCE, 200, lv - 1);
		}
	}

}
