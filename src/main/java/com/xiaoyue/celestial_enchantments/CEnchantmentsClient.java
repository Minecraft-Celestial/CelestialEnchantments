package com.xiaoyue.celestial_enchantments;

import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CelestialEnchantments.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CEnchantmentsClient {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(Items.ENCHANTED_BOOK, new ResourceLocation(CelestialEnchantments.MODID, "book"), (itemStack, clientLevel, livingEntity, i) -> {
				for (Enchantment enchantment : EnchantmentHelper.getEnchantments(itemStack).keySet()) {
					if (enchantment instanceof XCEnchBase) {
						return 2.0f;
					}
				}
				return 0;
			});
		});
	}
}
