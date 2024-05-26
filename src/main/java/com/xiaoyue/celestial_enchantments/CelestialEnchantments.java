package com.xiaoyue.celestial_enchantments;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CERecipeGen;
import com.xiaoyue.celestial_enchantments.data.CETagGen;
import com.xiaoyue.celestial_enchantments.event.CEAttackListener;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import com.xiaoyue.celestial_enchantments.register.CEItems;
import dev.xkmc.l2damagetracker.contents.attack.AttackEventHandler;
import dev.xkmc.l2library.base.L2Registrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.fml.common.Mod;
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
		CEEffects.register();
		CEItems.register();
		AttackEventHandler.register(3560, new CEAttackListener());
		REGISTRATE.addDataGenerator(ProviderType.LANG, CELang::genLang);
		REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CETagGen::onItemTagGen);
		REGISTRATE.addDataGenerator(ProviderType.RECIPE, CERecipeGen::onRecipeGen);
	}

	public static ResourceLocation loc(String id) {
		return new ResourceLocation(MODID, id);
	}

}
