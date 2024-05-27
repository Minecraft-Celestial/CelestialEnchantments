package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class TheSourceOfSin extends ArmorEnch {

	public TheSourceOfSin() {
		super(Rarity.RARE, Type.CHEST, EnchData.special(3, REACTIVE));
	}

	@Override
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {
			if (chance(user, level * 0.2)) {
				List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(livingEntity, 3, 2);
				for (LivingEntity list : entities) {
					list.setLastHurtByMob(livingEntity);
					list.setLastHurtMob(livingEntity);
				}
			}
		}
	}

}
