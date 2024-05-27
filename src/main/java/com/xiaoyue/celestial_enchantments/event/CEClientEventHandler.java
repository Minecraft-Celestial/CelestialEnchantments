package com.xiaoyue.celestial_enchantments.event;

import com.mojang.datafixers.util.Either;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class CEClientEventHandler {

	@SubscribeEvent
	public static void renderTooltip(RenderTooltipEvent.Color event) {
		ItemStack itemStack = event.getItemStack();
		if (itemStack.getItem() instanceof EnchantedBookItem) {
			for (Enchantment enchantment : EnchantmentHelper.getEnchantments(itemStack).keySet()) {
				if (enchantment instanceof CEBaseEnchantment) {
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
		boolean book = event.getItemStack().is(Items.ENCHANTED_BOOK);
		List<Either<Component, List<Component>>> compound = new ArrayList<>();
		for (var e : list) {
			compound.add(Either.left(e));
		}
		for (int i = 0; i < n; i++) {
			Component comp = list.get(i);
			Component lit;
			if (comp.getContents() instanceof LiteralContents txt && comp.getSiblings().size() == 1) {
				comp = comp.getSiblings().get(0);
				lit = Component.literal(txt.text());
			} else lit = Component.empty();
			if (comp.getContents() instanceof TranslatableContents tr) {
				if (tr.getKey().startsWith(prefix) &&
						tr.getKey().endsWith(suffix)) {
					String id = tr.getKey().substring("enchantment.celestial_enchantments.".length(),
							tr.getKey().length() - suffix.length());
					Enchantment ench = ForgeRegistries.ENCHANTMENTS.getValue(CelestialEnchantments.loc(id));
					if (ench instanceof CEBaseEnchantment base) {
						int lv = map.getOrDefault(ench, 0);
						var es = base.descFull(Math.min(base.getMaxLevel(), lv), tr.getKey(), alt, book);
						compound.set(i, Either.right(es.stream().map(e -> (Component) lit.copy().append(e)).toList()));
						flag = true;
					}
				}
			}
		}
		if (flag) {
			list.clear();
			list.addAll(compound.stream().flatMap(e -> e.map(Stream::of, Collection::stream)).toList());
		}
		if (!alt && flag) {
			list.add(CELang.alt());
		}
	}

}
