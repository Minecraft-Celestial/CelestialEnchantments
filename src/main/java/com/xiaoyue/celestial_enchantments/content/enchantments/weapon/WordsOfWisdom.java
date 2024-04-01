package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class WordsOfWisdom extends AttackEnch {

	private static double atk() {
		return 0.002;//TODO
	}

	private static int maxLv() {
		return 300;//TODO
	}

	public WordsOfWisdom() {
		super(Rarity.RARE, EnchConfigData.NORMAL_3);
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (user instanceof Player player) {
			float i = Math.min(player.experienceLevel, maxLv()) * (float) atk();
			cache.addHurtModifier(DamageModifier.multBase(i * lv));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.percSmall(lv, atk(), alt), CELang.perc(lv, atk() * maxLv(), alt));
	}
}
