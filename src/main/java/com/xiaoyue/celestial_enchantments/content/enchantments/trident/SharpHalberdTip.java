package com.xiaoyue.celestial_enchantments.content.enchantments.trident;

import com.xiaoyue.celestial_enchantments.content.generic.TridentEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.Nullable;

public class SharpHalberdTip extends TridentEnch {

	public SharpHalberdTip() {
		super(Rarity.VERY_RARE, EnchData.normal(5, TRIDENT));
	}

	@Override
	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
		cache.addHurtModifier(DamageModifier.multTotal(1 + lv * 0.2f));
	}

}
