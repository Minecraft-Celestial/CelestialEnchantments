package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;

public class ClusterAwareness extends AttackEnch {

	private static double atk() {
		return CEModConfig.COMMON.ench.weapon.clusterAwarenessDamage.get();
	}

	private static int radius() {
		return CEModConfig.COMMON.ench.weapon.clusterAwarenessRadius.get();
	}

	public ClusterAwareness() {
		super(Rarity.UNCOMMON, EnchData.normal(3, A75));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		int count = EntityUtils.getExceptForCentralEntity(user, radius(), 2, e -> e.getType() == user.getType()).size();
		cache.addHurtModifier(DamageModifier.multBase(lv * count * (float) atk()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}
}
