package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class HolyPrayer extends ArmorEnch {

	private static int dur() {
		return 2;
	}

	private static final EnchEffectEntry EFF = EnchEffectEntry.all(() -> MobEffects.REGENERATION, HolyPrayer::dur);

	public HolyPrayer() {
		super(Rarity.RARE, Type.LEGS, EnchData.treasure(3, EFFECT));
	}

	@Override
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (user instanceof Player player) {
			if (player.isCrouching()) {
				player.addEffect(EFF.ins(level));
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, EFF.comp(lv, alt));
	}

}
