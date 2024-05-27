package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DeathEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class DeathHatred extends DeathEnch {

	private static int damage() {
		return 15;
	}

	private static int radius(){
		return 6;
	}

	public DeathHatred() {
		super(Rarity.RARE, Type.CHEST, EnchData.normal(3, DEATH));
	}

	@Override
	public void onDeath(LivingEntity entity, int level) {
		if (!(entity instanceof Player)) return;
		List<LivingEntity> players = EntityUtils.getExceptForCentralEntity(entity, radius(), 2, livingEntity -> livingEntity instanceof Monster);
		for (LivingEntity list : players) {
			DamageSource damageSource = new DamageSource(entity.damageSources().magic().typeHolder());
			list.hurt(damageSource, level * (float) damage());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, damage(), alt));
	}

}
