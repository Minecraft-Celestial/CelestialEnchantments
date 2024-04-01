package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

public class ClusterAwareness extends AttackEnch {

	private static double atk() {
		return 0.03;//TODO
	}

	public ClusterAwareness() {
		super(Rarity.UNCOMMON, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		int count = 0;
		if (user instanceof Monster monster) {
			count = EntityUtils.getExceptForCentralEntity(monster, 6, 2, livingEntity -> livingEntity instanceof Monster).size();
		}
		if (user instanceof Player player) {
			count = EntityUtils.getExceptForCentralEntity(player, 6, 2, livingEntity -> livingEntity instanceof Player).size();
		}
		cache.addHurtModifier(DamageModifier.add(lv * count * (float) atk()));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}
}
