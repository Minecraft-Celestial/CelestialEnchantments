package com.xiaoyue.celestial_enchantments.enchantments.tool;

import com.xiaoyue.celestial_enchantments.generic.ToolEnch;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class AccelerateGrowth extends ToolEnch {

	public AccelerateGrowth() {
		super(Rarity.VERY_RARE, Type.HOE);
	}

	@Override
	public int getMaxLevel() {
		return super.getMaxLevel();
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	public static void onRightBlockEvent(PlayerInteractEvent.RightClickBlock event, int lv) {
		Player player = event.getEntity();
		BlockPos blockPos = event.getHitVec().getBlockPos();
		Block block = player.level().getBlockState(blockPos).getBlock();
		if (block instanceof CropBlock) {
			if (BoneMealItem.applyBonemeal(Items.BONE_MEAL.getDefaultInstance(), player.level(), blockPos, player)) {
				player.level().levelEvent(2005, blockPos, 0);
				event.getItemStack().hurtAndBreak(100, player, p -> p.broadcastBreakEvent(event.getHand()));
			}
		}
	}

}
