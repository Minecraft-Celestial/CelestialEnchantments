package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

public class MorningStar extends BowEnch {

  private static double chance() {
		return 0.25;
	}

	public MorningStar() {
		super(Rarity.RARE, EnchData.normal(3, ARROW_EFFECT));
	}

	@Override
	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		if (chance(target, chance() * lv)) {
			GeneralEventHandler.schedule(() -> EntityUtils.spawnThunder(target));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, chance(), alt));
	}

}