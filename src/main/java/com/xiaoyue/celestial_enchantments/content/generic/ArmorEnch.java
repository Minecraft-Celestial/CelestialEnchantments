package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;
import java.util.List;

public class ArmorEnch extends XCEnchBase {

	protected static final EnchGroup DEATH = EnchGroup.simple(CELang.DEATH, ChatFormatting.LIGHT_PURPLE);
	protected static final EnchGroup EFFECT = EnchGroup.simple(CELang.ARMOR_EFFECT, ChatFormatting.GREEN);
	protected static final EnchGroup REACTIVE = EnchGroup.simple(CELang.REACTIVE, ChatFormatting.DARK_AQUA);
	protected static final EnchGroup EXP = EnchGroup.simple(CELang.EXP, ChatFormatting.YELLOW);
	protected static final EnchGroup PROTECT = EnchGroup.simple(CELang.PROT, ChatFormatting.GOLD);

	private static final CELang[] LANGS = {CELang.FEET, CELang.LEGS, CELang.CHEST, CELang.HEAD};

	protected ArmorEnch(Rarity rarity, Type type, EnchData config) {
		super(rarity, type, config);
	}

	@Override
	public List<Component> descFull(int lv, String key, boolean alt, boolean isBook) {
		var ans = new ArrayList<>(super.descFull(lv, key, alt, isBook));
		if (!alt && isBook) {
			MutableComponent comp = Component.empty();
			for (var e : slots) {
				if (e.isArmor()) {
					comp.append(LANGS[e.getIndex()].get().withStyle(ChatFormatting.GRAY).append(CommonComponents.SPACE));
				}
			}
			ans.add(comp);
		}
		return ans;
	}
}
