package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class AttackEnch extends WeaponEnch {

	protected AttackEnch(Rarity rarity, EnchData data) {
		super(rarity, data);
	}

	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {

	}

	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {

	}

	public void onKillEntity(LivingDeathEvent event, LivingEntity user, LivingEntity target, int lv) {
	}

}
