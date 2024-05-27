package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchGroup;
import net.minecraft.ChatFormatting;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;

public class WeaponEnch extends CEBaseEnchantment {

	protected static final EnchGroup INFLICT = EnchGroup.simple(CELang.INFLICT, ChatFormatting.GREEN);
	protected static final EnchGroup A30 = EnchGroup.simple(CELang.BLADE, ChatFormatting.YELLOW);
	protected static final EnchGroup A75 = EnchGroup.simple(CELang.BERSERK, ChatFormatting.AQUA);
	protected static final EnchGroup A300 = EnchGroup.simple(CELang.EPIC, ChatFormatting.GOLD);

	protected WeaponEnch(Rarity rarity, EnchData data) {
		super(rarity, Type.WEAPON, data);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return super.canApplyAtEnchantingTable(stack) || stack.is(ItemTags.AXES) || stack.is(Tags.Items.TOOLS_TRIDENTS);
	}

}
