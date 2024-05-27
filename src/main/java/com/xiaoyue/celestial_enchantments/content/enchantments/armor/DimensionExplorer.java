package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class DimensionExplorer extends ArmorEnch {

	private static int dur() {
		return 60;
	}

	private static final EnchEffectEntry LUCK = EnchEffectEntry.amp(() -> MobEffects.LUCK, DimensionExplorer::dur);
	private static final EnchEffectEntry DMG = EnchEffectEntry.amp(() -> MobEffects.DAMAGE_BOOST, DimensionExplorer::dur);
	private static final EnchEffectEntry DIG = EnchEffectEntry.amp(() -> MobEffects.DIG_SPEED, DimensionExplorer::dur);

	public DimensionExplorer() {
		super(Rarity.RARE, Type.FEET, EnchData.normal(3, EFFECT));
	}

	public static void onLevelChange(Player player, int lv) {
		player.addEffect(LUCK.ins(lv));
		player.addEffect(DMG.ins(lv));
		player.addEffect(DIG.ins(lv));
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, LUCK.comp(lv, alt), DMG.comp(lv, alt), DIG.comp(lv, alt));
	}

}
