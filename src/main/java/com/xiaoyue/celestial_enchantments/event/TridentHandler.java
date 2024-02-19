package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_core.utils.LevelUtils;
import com.xiaoyue.celestial_enchantments.mixin.MixinTrident;
import com.xiaoyue.celestial_enchantments.register.CEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TridentHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();
        Entity direct = event.getSource().getDirectEntity();
        if (direct instanceof ThrownTrident trident) {
            ItemStack tridentItem = ((MixinTrident) trident).getTridentItem();

            int EXPLOSIVE_HALBERD = tridentItem.getEnchantmentLevel(CEnchantments.EXPLOSIVE_HALBERD.get());
            if (EXPLOSIVE_HALBERD > 0) {
                if (LevelUtils.isServerLevel(target.level())) {
                    if (Math.random() < EXPLOSIVE_HALBERD * 0.2) {
                        target.level().explode(attacker, target.getX(), target.getY(), target.getZ(), 1.0f, Level.ExplosionInteraction.NONE);
                    }
                }
            }

            int SHARP_HALBERD_TIP = tridentItem.getEnchantmentLevel(CEnchantments.SHARP_HALBERD_TIP.get());
            if (SHARP_HALBERD_TIP > 0) {
                event.setAmount(event.getAmount() * (1 + (SHARP_HALBERD_TIP * 0.2f)));
            }
        }
    }
}
