package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ChangeXpEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class KnowledgeScholar extends ArmorEnch implements ChangeXpEnch {

  private static double exp() {
		return CEModConfig.COMMON.ench.armor.knowledgeScholarExpBonus.get();
	}

	public KnowledgeScholar() {
		super(Rarity.UNCOMMON, Type.HEAD, EnchData.normal(3, EXP));
	}

	@Override
	public float onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
		return level * (float) exp();
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, exp(), alt));
	}

}
