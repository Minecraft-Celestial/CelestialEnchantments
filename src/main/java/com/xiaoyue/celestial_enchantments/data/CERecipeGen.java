package com.xiaoyue.celestial_enchantments.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.xiaoyue.celestial_core.register.CCItems;
import com.xiaoyue.celestial_enchantments.register.CEItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.BiFunction;

public class CERecipeGen {

	public static void onRecipeGen(RegistrateRecipeProvider pvd) {
		unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CEItems.TABLE)::unlockedBy, CEItems.BASIC_FUEL.get())
				.pattern(" B ").pattern("TRT").pattern("OOO")
				.define('B', Items.ENCHANTED_BOOK)
				.define('T', CEItems.BASIC_FUEL)
				.define('R', Items.REDSTONE_BLOCK)
				.define('O', Items.CRYING_OBSIDIAN)
				.save(pvd);

		unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CEItems.BASIC_FUEL)::unlockedBy, Items.LAPIS_LAZULI)
				.requires(Items.LAPIS_LAZULI).requires(Items.REDSTONE).requires(Items.GOLD_INGOT).requires(Items.AMETHYST_SHARD)
				.requires(CETagGen.BASIC_INGREDIENTS).save(pvd);

		unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CEItems.ADVANCED_FUEL)::unlockedBy, CEItems.BASIC_FUEL.get())
				.requires(CEItems.BASIC_FUEL).requires(CEItems.BASIC_FUEL).requires(Items.DIAMOND)
				.requires(CETagGen.ADVANCED_INGREDIENTS).save(pvd);

		unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CEItems.LEGENDARY_FUEL)::unlockedBy, CEItems.ADVANCED_FUEL.get())
				.requires(CEItems.ADVANCED_FUEL).requires(CEItems.ADVANCED_FUEL).requires(Items.NETHERITE_SCRAP)
				.requires(CETagGen.LEGENDARY_INGREDIENTS).save(pvd);
	}

	public static <T> T unlock(RegistrateRecipeProvider pvd, BiFunction<String, InventoryChangeTrigger.TriggerInstance, T> func, Item item) {
		return func.apply("has_" + pvd.safeName(item), DataIngredient.items(item).getCritereon(pvd));
	}

}
