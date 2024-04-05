package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.data.CELang;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class CEClientEventHandler {

	@SubscribeEvent
	public static void renderTooltip(RenderTooltipEvent.Color event) {
		ItemStack itemStack = event.getItemStack();
		if (itemStack.getItem() instanceof EnchantedBookItem) {
			for (Enchantment enchantment : EnchantmentHelper.getEnchantments(itemStack).keySet()) {
				if (enchantment instanceof XCEnchBase) {
					event.setBorderStart(0xFF87CEFA);
					event.setBorderEnd(0xFF87CEFA);
				}
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void modifyItemTooltip(ItemTooltipEvent event) {
		var list = event.getToolTip();
		int n = list.size();
		if (!event.getItemStack().isEnchanted() && !event.getItemStack().is(Items.ENCHANTED_BOOK)) return;
		var map = EnchantmentHelper.getEnchantments(event.getItemStack());
		String prefix = "enchantment.celestial_enchantments.";
		String suffix = ".desc";
		boolean alt = Screen.hasAltDown();
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			Component comp = list.get(i);
			var lit = Component.empty();
			if (comp.getContents() instanceof LiteralContents txt && comp.getSiblings().size() == 1) {
				comp = comp.getSiblings().get(0);
				lit = Component.literal(txt.text());
			}
			if (comp.getContents() instanceof TranslatableContents tr) {
				if (tr.getKey().startsWith(prefix) &&
						tr.getKey().endsWith(suffix)) {
					String id = tr.getKey().substring("enchantment.celestial_enchantments.".length(),
							tr.getKey().length() - suffix.length());
					Enchantment ench = ForgeRegistries.ENCHANTMENTS.getValue(CelestialEnchantments.loc(id));
					if (ench instanceof XCEnchBase base) {
						int lv = map.getOrDefault(ench, 0);
						list.set(i, lit.append(base.descFull(lv, tr.getKey(), alt)));
						flag = true;
					}
				}
			}
		}
		if (!alt && flag) {
			list.add(CELang.alt());
		}
	}

}
