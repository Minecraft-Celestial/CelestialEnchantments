package com.xiaoyue.celestial_enchantments;

import com.mojang.logging.LogUtils;
import com.xiaoyue.celestial_enchantments.config.CommonConfig;
import com.xiaoyue.celestial_enchantments.event.IGenericHandler;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.register.CECreativeTabs;
import com.xiaoyue.celestial_enchantments.register.CEnchantments;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CelestialEnchantments.MODID)
public class CelestialEnchantments
{
    public static final String MODID = "celestial_enchantments";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CelestialEnchantments()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CEnchantments.ENCHANTMENTS.register(modEventBus);
        CECreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new IGenericHandler());
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.spec);
    }

}
