package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchConfigData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class MisfortuneBlade extends AttackEnch {

	public MisfortuneBlade() {
		super(Rarity.RARE, EnchConfigData.treasure(3));
	}

	@Override
	public void onHurtTarget(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (target.hasEffect(MobEffects.POISON)) {
			cache.addHurtModifier(DamageModifier.multTotal(1 + (lv * 0.25f)));
		} else {
			EntityUtils.addEct(target, MobEffects.POISON, 80, lv - 1);
		}
	}

}
