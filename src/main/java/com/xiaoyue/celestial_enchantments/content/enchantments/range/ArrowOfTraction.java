package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

import java.util.List;

public class ArrowOfTraction extends BowEnch {

	public ArrowOfTraction() {
		super(Rarity.RARE, EnchData.normal(3, ARROW_EFFECT));
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, lv, 2);
		for (LivingEntity list : entities) {
			list.teleportTo(target.getX(), target.getY(), target.getZ());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, 1, alt));
	}

}