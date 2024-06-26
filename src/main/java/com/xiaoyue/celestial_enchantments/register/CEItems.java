package com.xiaoyue.celestial_enchantments.register;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.MenuEntry;
import com.xiaoyue.celestial_core.CelestialCore;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.table.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CEItems {

	public static final BlockEntry<CelestialTableBlock> TABLE;
	public static final BlockEntityEntry<CelestialTableBlockEntity> BE_TABLE;
	public static final MenuEntry<CelestialTableMenu> MT_TABLE;

	public static final ItemEntry<Item> BASIC_FUEL, ADVANCED_FUEL, LEGENDARY_FUEL;

	static {

		CelestialEnchantments.REGISTRATE.defaultCreativeTab(CelestialCore.TAB.getKey());

		TABLE = CelestialEnchantments.REGISTRATE.block("celestial_enchanting_table", p -> new CelestialTableBlock(
						BlockBehaviour.Properties.copy(Blocks.ENCHANTING_TABLE)))
				.blockstate((ctx, pvd) -> pvd.simpleBlock(ctx.get(), pvd.models()
						.withExistingParent(ctx.getName(), "block/enchanting_table")
						.texture("particle",pvd.modLoc("block/table_bottom"))
						.texture("bottom",pvd.modLoc("block/table_bottom"))
						.texture("top",pvd.modLoc("block/table_top"))
						.texture("side",pvd.modLoc("block/table_side"))
				))
				.simpleItem()
				.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_DIAMOND_TOOL)
				.register();

		BE_TABLE = CelestialEnchantments.REGISTRATE.blockEntity("celestial_enchanting_table", CelestialTableBlockEntity::new)
				.validBlock(TABLE).renderer(() -> CelestialTableRenderer::new).register();

		MT_TABLE = CelestialEnchantments.REGISTRATE.menu("celestial_enchanting_table",
						CelestialTableMenu::fromNetwork, () -> CelestialTableScreen::new)
				.register();

		BASIC_FUEL = CelestialEnchantments.REGISTRATE.item("basic_celestial_catalyst", Item::new).register();
		ADVANCED_FUEL = CelestialEnchantments.REGISTRATE.item("advanced_celestial_catalyst", Item::new).register();
		LEGENDARY_FUEL = CelestialEnchantments.REGISTRATE.item("legendary_celestial_catalyst", Item::new).register();
	}

	public static final ItemEntry[] FUELS = {BASIC_FUEL, ADVANCED_FUEL, LEGENDARY_FUEL};

	public static void register() {

	}

}
