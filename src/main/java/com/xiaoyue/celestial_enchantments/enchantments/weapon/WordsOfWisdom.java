package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class WordsOfWisdom extends AttackEnch {

	public WordsOfWisdom() {
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
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user instanceof Player player) {
			int experienceLevel = player.experienceLevel;
			float i = ((float) experienceLevel / 5) * 0.05f;
			float min = Math.min(i, 0.2f * lv);
			cache.addHurtModifier(DamageModifier.multTotal(1 + min));
		}
	}
}
