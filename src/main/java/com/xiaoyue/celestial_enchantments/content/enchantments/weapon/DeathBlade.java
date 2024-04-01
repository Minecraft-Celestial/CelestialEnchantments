package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;

public class DeathBlade extends AttackEnch {
	public DeathBlade() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_5);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		float add = target.getMaxHealth() * 0.01f * lv;
		cache.addHurtModifier(DamageModifier.addExtra(add));
	}
}
