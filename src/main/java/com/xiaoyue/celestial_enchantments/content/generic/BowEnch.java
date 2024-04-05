package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.enchantment.Enchantments;

public class BowEnch extends XCEnchBase {

	public static final EnchGroup ARROW = EnchGroup.of(ChatFormatting.AQUA, () -> Enchantments.POWER_ARROWS);
	public static final EnchGroup ARROW_EFFECT = EnchGroup.of(ChatFormatting.AQUA, () -> Enchantments.FLAMING_ARROWS);

	protected BowEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.BOW, config);
	}

	public void hurtTarget(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

	public void onDamageTargetFinal(Arrow arrow, LivingEntity target, int lv, AttackCache cache) {
	}

}
