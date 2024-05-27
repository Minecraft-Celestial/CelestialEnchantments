package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class HaveNiceDream extends ArmorEnch {

	private static int time() {
		return 60;
	}

	private static final EnchEffectEntry REGEN = EnchEffectEntry.amp(() -> MobEffects.REGENERATION, HaveNiceDream::time);
	private static final EnchEffectEntry DIG = EnchEffectEntry.amp(() -> MobEffects.DIG_SPEED, HaveNiceDream::time);

	public HaveNiceDream() {
		super(Rarity.RARE, Type.HEAD, EnchData.normal(3, EFFECT));
	}

	public static void onPlayerWake(Player player, int lv) {
		player.addEffect(REGEN.ins(lv));
		player.addEffect(DIG.ins(lv));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, REGEN.comp(lv, alt), DIG.comp(lv, alt));
	}
}
