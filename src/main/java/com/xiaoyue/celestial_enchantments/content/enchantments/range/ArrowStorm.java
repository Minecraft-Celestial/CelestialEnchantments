package com.xiaoyue.celestial_enchantments.content.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.BowEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;

import java.util.List;

public class ArrowStorm extends BowEnch {

	public ArrowStorm() {
		super(Rarity.RARE, EnchData.normal(3,ARROW));
	}

	@Override
	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		cache.addHurtModifier(DamageModifier.multTotal(1 - lv * 0.05f));
	}

	@Override
	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, 5, 2);
		float damage = cache.getPreDamage() * lv * 0.1f;
		DamageSource source = new DamageSource(getSource(cache).typeHolder());
		for (LivingEntity list : entities) {
			GeneralEventHandler.schedule(() -> list.hurt(source, damage));
		}
	}

}
