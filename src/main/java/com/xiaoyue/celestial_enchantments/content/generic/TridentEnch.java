package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchGroup;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.Nullable;

public class TridentEnch extends CEBaseEnchantment {

	public static final EnchGroup TRIDENT = EnchGroup.simple(CELang.TRIDENT, ChatFormatting.DARK_AQUA);

	protected TridentEnch(Rarity rarity, EnchData config) {
		super(rarity, Type.TRIDENT, config);
	}

	public void hurtTarget(@Nullable ThrownTrident trident, LivingEntity target, int lv, AttackCache cache) {
	}

}
