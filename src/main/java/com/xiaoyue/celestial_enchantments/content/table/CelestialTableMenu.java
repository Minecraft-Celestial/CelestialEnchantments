package com.xiaoyue.celestial_enchantments.content.table;

import com.xiaoyue.celestial_enchantments.register.CEItems;
import net.minecraft.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;

import java.util.List;


public class CelestialTableMenu extends AbstractContainerMenu {

	public static int getFuelLevel(ItemStack stack) {
		if (stack.is(CEItems.BASIC_FUEL.get())) return 1;
		if (stack.is(CEItems.ADVANCED_FUEL.get())) return 2;
		if (stack.is(CEItems.LEGENDARY_FUEL.get())) return 3;
		return 0;
	}

	private final Container enchantSlots = new SimpleContainer(2) {

		public void setChanged() {
			super.setChanged();
			slotsChanged(this);
		}

	};

	private final ContainerLevelAccess access;
	private final RandomSource random = RandomSource.create();
	private final DataSlot enchantmentSeed = DataSlot.standalone();

	public final int[] costs = new int[3];
	public final int[] enchantClue = new int[]{-1, -1, -1};
	public final int[] levelClue = new int[]{-1, -1, -1};

	public static CelestialTableMenu fromNetwork(MenuType<? extends CelestialTableMenu> type, int wid, Inventory inv) {
		return new CelestialTableMenu(type, wid, inv, ContainerLevelAccess.NULL);
	}

	public CelestialTableMenu(MenuType<? extends CelestialTableMenu> type, int wid, Inventory inv, ContainerLevelAccess pAccess) {
		super(type, wid);
		access = pAccess;
		addSlot(new Slot(enchantSlots, 0, 15, 47) {

			public boolean mayPlace(ItemStack stack) {
				return true;
			}

			public int getMaxStackSize() {
				return 1;
			}

		});

		addSlot(new Slot(enchantSlots, 1, 35, 47) {

			public boolean mayPlace(ItemStack stack) {
				return getFuelLevel(stack) > 0;
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			addSlot(new Slot(inv, k, 8 + k * 18, 142));
		}

		addDataSlot(DataSlot.shared(costs, 0));
		addDataSlot(DataSlot.shared(costs, 1));
		addDataSlot(DataSlot.shared(costs, 2));
		addDataSlot(enchantmentSeed).set(inv.player.getEnchantmentSeed());
		addDataSlot(DataSlot.shared(enchantClue, 0));
		addDataSlot(DataSlot.shared(enchantClue, 1));
		addDataSlot(DataSlot.shared(enchantClue, 2));
		addDataSlot(DataSlot.shared(levelClue, 0));
		addDataSlot(DataSlot.shared(levelClue, 1));
		addDataSlot(DataSlot.shared(levelClue, 2));
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void slotsChanged(Container inv) {
		if (inv == enchantSlots) {
			ItemStack itemstack = inv.getItem(0);
			if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
				access.execute((level, pos) -> refreshEnchantments(itemstack, level, pos));
			} else {
				for (int i = 0; i < 3; ++i) {
					costs[i] = 0;
					enchantClue[i] = -1;
					levelClue[i] = -1;
				}
			}
		}

	}

	private void refreshEnchantments(ItemStack stack, Level level, BlockPos pos) {
		float shelfs = 0;
		for (BlockPos offset : CelestialTableBlock.BOOKSHELF_OFFSETS) {
			if (CelestialTableBlock.isValidBookShelf(level, pos, offset)) {
				shelfs += level.getBlockState(pos.offset(offset)).getEnchantPowerBonus(level, pos.offset(offset));
			}
		}

		random.setSeed(enchantmentSeed.get());

		for (int rank = 0; rank < 3; ++rank) {
			costs[rank] = EnchantmentHelper.getEnchantmentCost(random, 2, (int) shelfs, stack);
			enchantClue[rank] = -1;
			levelClue[rank] = -1;
			if (costs[rank] < 10) {
				costs[rank] = 0;
			}
		}

		for (int l = 0; l < 3; ++l) {
			if (costs[l] > 0) {
				List<EnchantmentInstance> list = getEnchantmentList(stack, l, costs[l]);
				if (!list.isEmpty()) {
					EnchantmentInstance ins = list.get(random.nextInt(list.size()));
					enchantClue[l] = BuiltInRegistries.ENCHANTMENT.getId(ins.enchantment);
					levelClue[l] = ins.level;
				}
			}
		}

		broadcastChanges();
	}

	/**
	 * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
	 */
	public boolean clickMenuButton(Player player, int pId) {
		if (pId >= 0 && pId < costs.length) {
			ItemStack tool = enchantSlots.getItem(0);
			ItemStack fuel = enchantSlots.getItem(1);
			int i = pId + 1;
			if ((fuel.isEmpty() || getFuelLevel(fuel) <= pId) && !player.getAbilities().instabuild) {
				return false;
			} else if (costs[pId] <= 0 || tool.isEmpty() || (player.experienceLevel < i || player.experienceLevel < costs[pId] * (pId + 1)) && !player.getAbilities().instabuild) {
				return false;
			} else {
				access.execute((level, pos) -> onEnchant(player, tool, fuel, pId, level, pos));
				return true;
			}
		} else {
			Util.logAndPauseIfInIde(player.getName() + " pressed invalid button id: " + pId);
			return false;
		}
	}

	private void onEnchant(Player player, ItemStack tool, ItemStack fuel, int btn, Level level, BlockPos pos) {
		int spent = (btn + 1) * 10;
		ItemStack newTool = tool;
		List<EnchantmentInstance> list = getEnchantmentList(tool, btn, costs[btn]);
		if (!list.isEmpty()) {
			player.onEnchantmentPerformed(tool, spent);
			boolean flag = tool.is(Items.BOOK);
			if (flag) {
				newTool = new ItemStack(Items.ENCHANTED_BOOK);
				CompoundTag tag = tool.getTag();
				if (tag != null) {
					newTool.setTag(tag.copy());
				}
				enchantSlots.setItem(0, newTool);
			}

			for (EnchantmentInstance ins : list) {
				if (flag) {
					EnchantedBookItem.addEnchantment(newTool, ins);
				} else {
					newTool.enchant(ins.enchantment, ins.level);
				}
			}

			if (!player.getAbilities().instabuild) {
				fuel.shrink(1);
				if (fuel.isEmpty()) {
					enchantSlots.setItem(1, ItemStack.EMPTY);
				}
			}

			player.awardStat(Stats.ENCHANT_ITEM);
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.ENCHANTED_ITEM.trigger((ServerPlayer) player, newTool, spent);
			}

			enchantSlots.setChanged();
			enchantmentSeed.set(player.getEnchantmentSeed());
			slotsChanged(enchantSlots);
			level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.0F, level.random.nextFloat() * 0.1F + 0.9F);
		}

	}

	private List<EnchantmentInstance> getEnchantmentList(ItemStack pStack, int slot, int pLevel) {
		random.setSeed(enchantmentSeed.get() + slot);
		List<EnchantmentInstance> list = CelestialEnchantmentHelper.selectEnchantment(random, pStack, slot, pLevel);
		if (pStack.is(Items.BOOK) && list.size() > 1) {
			list.remove(random.nextInt(list.size()));
		}

		return list;
	}

	public int getGoldCount() {
		ItemStack itemstack = enchantSlots.getItem(1);
		return itemstack.isEmpty() ? 0 : getFuelLevel(itemstack);
	}

	public int getEnchantmentSeed() {
		return enchantmentSeed.get();
	}

	public void removed(Player player) {
		super.removed(player);
		access.execute((level, pos) -> clearContainer(player, enchantSlots));
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean stillValid(Player pPlayer) {
		return stillValid(access, pPlayer, CEItems.TABLE.get());
	}

	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		ItemStack ans = ItemStack.EMPTY;
		Slot slot = slots.get(pIndex);
		if (slot.hasItem()) {
			ItemStack inSlot = slot.getItem();
			ans = inSlot.copy();
			if (pIndex == 0) {
				if (!moveItemStackTo(inSlot, 2, 38, true)) {
					return ItemStack.EMPTY;
				}
			} else if (pIndex == 1) {
				if (!moveItemStackTo(inSlot, 2, 38, true)) {
					return ItemStack.EMPTY;
				}
			} else if (getFuelLevel(inSlot) > 0) {
				if (!moveItemStackTo(inSlot, 1, 2, true)) {
					return ItemStack.EMPTY;
				}
			} else {
				if (slots.get(0).hasItem() || !slots.get(0).mayPlace(inSlot)) {
					return ItemStack.EMPTY;
				}

				ItemStack copy = inSlot.copyWithCount(1);
				inSlot.shrink(1);
				slots.get(0).setByPlayer(copy);
			}

			if (inSlot.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (inSlot.getCount() == ans.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(pPlayer, inSlot);
		}

		return ans;
	}
}
