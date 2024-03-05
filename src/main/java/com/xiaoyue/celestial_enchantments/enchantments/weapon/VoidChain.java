package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.AttackEnch;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;

public class VoidChain extends AttackEnch {

	public VoidChain() {
		super(Rarity.RARE);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 8) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 8);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.SWEEPING_EDGE;
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		cache.addHurtModifier(DamageModifier.multTotal(0.1f));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(user, 6, 2);
		for (LivingEntity list : entities) {
			list.hurt(CCDamageTypes.abyss(user), cache.getDamageDealt() * (5f * lv));
		}
	}
}
