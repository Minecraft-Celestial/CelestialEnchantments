package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.content.enchantments.armor.DimensionExplorer;
import com.xiaoyue.celestial_enchantments.content.enchantments.armor.HaveNiceDream;
import com.xiaoyue.celestial_enchantments.content.enchantments.armor.PotionAffinity;
import com.xiaoyue.celestial_enchantments.content.enchantments.tool.AccelerateGrowth;
import com.xiaoyue.celestial_enchantments.register.CEEffects;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CEMiscEventHandler {

	@SubscribeEvent
	public static void onLevelChange(PlayerEvent.PlayerChangedDimensionEvent event) {
		Player player = event.getEntity();
		int lv = EnchantmentHelper.getEnchantmentLevel(CEEnchantments.DIMENSION_EXPLORER.get(), player);
		if (lv > 0) DimensionExplorer.onLevelChange(player, lv);
	}

	@SubscribeEvent
	public static void onAddedEffect(MobEffectEvent.Added event) {
		LivingEntity entity = event.getEntity();
		int lv = EnchantmentHelper.getEnchantmentLevel(CEEnchantments.POTION_AFFINITY.get(), entity);
		if (lv > 0) PotionAffinity.onAddedEffect(entity, lv, event.getEffectInstance());
	}

	@SubscribeEvent
	public static void onPlayerWake(PlayerWakeUpEvent event) {
		Player player = event.getEntity();
		int lv = EnchantmentHelper.getEnchantmentLevel(CEEnchantments.HAVE_NICE_DREAM.get(), player);
		if (lv > 0 && event.wakeImmediately()) HaveNiceDream.onPlayerWake(player, lv);
	}

	@SubscribeEvent
	public static void onRightBlockEvent(PlayerInteractEvent.RightClickBlock event) {
		Player player = event.getEntity();
		int lv = EnchantmentHelper.getEnchantmentLevel(CEEnchantments.ACCELERATE_GROWTH.get(), player);
		if (lv > 0) AccelerateGrowth.onRightBlockEvent(event, lv);
	}

	@SubscribeEvent
	public static void onLivingHeal(LivingHealEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity.hasEffect(CEEffects.SUPPRESSED.get())) {
			event.setCanceled(true);
		}
	}

}
