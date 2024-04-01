package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

import java.util.List;

public class ArrowOfTraction extends BowEnch {

	public ArrowOfTraction() {
		super(Rarity.RARE, EnchConfigData.NORMAL_3);
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, lv + 1, 2);
		for (LivingEntity list : entities) {
			list.teleportTo(target.getX(), target.getY(), target.getZ());
		}
	}

}