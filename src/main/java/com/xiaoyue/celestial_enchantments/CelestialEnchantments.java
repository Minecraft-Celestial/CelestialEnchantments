package com.xiaoyue.celestial_enchantments;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.xiaoyue.celestial_enchantments.config.CommonConfig;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import dev.xkmc.l2library.base.L2Registrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(CelestialEnchantments.MODID)
public class CelestialEnchantments {

	public static final String MODID = "celestial_enchantments";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final L2Registrate REGISTRATE = new L2Registrate(MODID);

	public static final RegistryEntry<CreativeModeTab> TAB_ENCHMIN = REGISTRATE.buildModCreativeTab(
			"min_enchantment", "Celestial Enchantments - Min Level", b -> b.icon(Items.BOOK::getDefaultInstance));

	public static final RegistryEntry<CreativeModeTab> TAB_ENCHMAX = REGISTRATE.buildModCreativeTab(
			"max_enchantment", "Celestial Enchantments - Max Level", b -> b.icon(() ->
							EnchantedBookItem.createForEnchantment(new EnchantmentInstance(CEEnchantments.ACCELERATE_GROWTH.get(), 1)))
					.withTabsBefore(TAB_ENCHMIN.getKey()));

	public CelestialEnchantments() {
		CEEnchantments.register();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.spec);
	}

	public static ResourceLocation loc(String id) {
		return new ResourceLocation(MODID, id);
	}

}
