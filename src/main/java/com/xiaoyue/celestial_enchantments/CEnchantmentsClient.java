package com.xiaoyue.celestial_enchantments;

import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
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
		event.enqueueWork(() -> ItemProperties.register(Items.ENCHANTED_BOOK, new ResourceLocation(CelestialEnchantments.MODID, "book"),
				(stack, clientLevel, entity, i) -> {
					int index = 0;
					int count = 0;
					for (Enchantment enchantment : EnchantmentHelper.getEnchantments(stack).keySet()) {
						if (enchantment instanceof CEBaseEnchantment ce) {
							index = CEEnchantments.ALL_ENCH.getOrDefault(ce.getID().getPath(), 0);
							count++;
						}
					}
					if (count >= 2) {
						return 222;
					}
					return index;
				}));
	}
}
