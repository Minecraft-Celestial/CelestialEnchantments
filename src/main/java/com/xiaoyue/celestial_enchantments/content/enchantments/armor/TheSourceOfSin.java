package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class TheSourceOfSin extends ArmorEnch {

	private static double chance() {
		return 0.2;
	}

	private static int radius(){
		return 3;
	}

	public TheSourceOfSin() {
		super(Rarity.RARE, Type.CHEST, EnchData.special(3, REACTIVE));
	}

	@Override
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			if (chance(user, level * chance())) {
				List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(livingEntity, radius(), 2);
				for (LivingEntity list : entities) {
					list.setLastHurtByMob(livingEntity);
					list.setLastHurtMob(livingEntity);
				}
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, chance(), alt));
	}

}
