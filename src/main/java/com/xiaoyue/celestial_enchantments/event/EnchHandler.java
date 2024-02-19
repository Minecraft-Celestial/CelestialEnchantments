package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.register.CEnchantments;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnchHandler {

    @SubscribeEvent
    public static void onPlayerWake(PlayerWakeUpEvent event) {
        Player player = event.getEntity();
        int level = EnchantmentHelper.getEnchantmentLevel(CEnchantments.HAVE_NICE_DREAM.get(), player);
        if (level > 0) {
            if (event.wakeImmediately()) {
                EntityUtils.addEct(player, MobEffects.REGENERATION, 200, level - 1);
                EntityUtils.addEct(player, MobEffects.JUMP, 200, level - 1);
            }
        }
    }
}
