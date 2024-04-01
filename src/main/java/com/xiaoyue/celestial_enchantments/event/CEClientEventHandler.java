package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.content.generic.XCEnchBase;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
}
