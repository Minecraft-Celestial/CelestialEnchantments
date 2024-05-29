package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class TheSourceOfSin extends DefenceEnch {

	private static double chance() {
		return CEModConfig.COMMON.ench.armor.theSourceOfSinChance.get();
	}

	private static int radius(){
		return CEModConfig.COMMON.ench.armor.theSourceOfSinRadius.get();
	}

	public TheSourceOfSin() {
		super(Rarity.RARE, Type.CHEST, EnchData.special(3, REACTIVE));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		if (cache.getAttacker() != null) {
			if (chance(user, lv * chance())) {
				List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(cache.getAttacker(), radius(), radius());
				for (LivingEntity list : entities) {
					list.setLastHurtByMob(cache.getAttacker());
					list.setLastHurtMob(cache.getAttacker());
				}
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, chance(), alt), CELang.num(radius()));
	}

}
