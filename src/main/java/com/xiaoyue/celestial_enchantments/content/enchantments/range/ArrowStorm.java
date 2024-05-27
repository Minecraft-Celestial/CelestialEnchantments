package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

import java.util.List;

public class ArrowStorm extends BowEnch {

	private static double atk() {
		return 0.1;
	}

	private static int radius() {
		return 5;
	}

	public ArrowStorm() {
		super(Rarity.RARE, EnchData.special(3,ARROW));
	}

	@Override
	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		var user = cache.getAttacker();
		if (user == null) return;
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, radius(), 2);
		float damage = cache.getPreDamage() * lv * (float) atk();
		for (LivingEntity list : entities) {
			GeneralEventHandler.schedule(() -> list.hurt(CCDamageTypes.magic(user), damage));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, atk(), alt));
	}

}
