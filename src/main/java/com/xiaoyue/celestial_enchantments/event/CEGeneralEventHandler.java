package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.content.generic.*;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CEGeneralEventHandler {

	@SubscribeEvent
	public static void onItemAttributes(ItemAttributeModifierEvent event) {
		ItemStack stack = event.getItemStack();
		if (stack.isEnchanted()) {
			for (var ent : EnchantmentHelper.getEnchantments(stack).entrySet()) {
				if (ent.getKey() instanceof AttributeEnchantment attr) {
					attr.addAttributes(ent.getValue(), event);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPLayerBreak(PlayerEvent.BreakSpeed event) {
		float factor = 1;
		for (var entry : IEnchUtils.getEnch(event.getEntity(), EquipmentSlot.MAINHAND).entrySet()) {
			if (entry.getKey() instanceof PlayerBreakEnch ench) {
				factor *= ench.onBreakSpeed(event, event.getEntity(), event.getState(), entry.getValue());
			}
		}
		if (factor != 1) {
			event.setNewSpeed(event.getNewSpeed() * factor);
		}
	}

	@SubscribeEvent
	public static void onPickupXp(PlayerXpEvent.PickupXp event) {
		float val = 1;
		for (var entry : IEnchUtils.getAllEnch(event.getEntity()).entrySet()) {
			if (entry.getKey() instanceof ChangeXpEnch ench) {
				val += ench.onPickupXp(event, event.getEntity(), entry.getValue(), event.getOrb());
			}
		}
		event.getOrb().value = (int) (event.getOrb().value * val);
	}

	@SubscribeEvent
	public static void onLivingHeal(LivingHealEvent event) {
		for (var entry : IEnchUtils.getArmorEnch(event.getEntity()).entrySet()) {
			if (entry.getKey() instanceof LivingHealEnch ench) {
				ench.onLivingHeal(event, event.getEntity(), entry.getValue());
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public static void onLivingDeath(LivingDeathEvent event) {
		for (var entry : IEnchUtils.getArmorEnch(event.getEntity()).entrySet()) {
			if (entry.getKey() instanceof DeathEnch ench) {
				ench.onDeath(event.getEntity(), entry.getValue());
			}
		}
	}

	@SubscribeEvent
	public static void onShieldBlock(ShieldBlockEvent event) {
		if (event.getDamageSource().getEntity() instanceof LivingEntity attacker) {
			for (var entry : IEnchUtils.getHeldEnch(event.getEntity()).entrySet()) {
				if (entry.getKey() instanceof ShieldEnch ench) {
					ench.onShieldBlock(event, attacker, event.getEntity(), entry.getValue());
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingTick(LivingEvent.LivingTickEvent event) {
		for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllEnch(event.getEntity()).entrySet()) {
			if (entry.getKey() instanceof LivingTickEnch ench) {
				ench.onLivingTick(event, event.getEntity(), entry.getValue());
			}
		}
	}

	@SubscribeEvent
	public static void onKillEntity(LivingDeathEvent event) {
		if (event.getSource().getEntity() instanceof LivingEntity attacker) {
			for (var entry : IEnchUtils.getEnch(attacker, EquipmentSlot.MAINHAND).entrySet()) {
				if (entry.getKey() instanceof AttackEnch ench) {
					ench.onKillEntity(event, attacker, event.getEntity(), entry.getValue());
				}
			}
		}
	}

	private static final ThreadLocal<BowInfo> TEMP = new ThreadLocal<>();

	private record BowInfo(ItemStack stack, Player user, int tickCount) {
	}

	@SubscribeEvent
	public static void onArrowLoose(ArrowLooseEvent event) {
		TEMP.set(new BowInfo(event.getBow(), event.getEntity(), event.getEntity().tickCount));
	}

	@SubscribeEvent
	public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
		if (event.getEntity() instanceof Arrow arrow) {
			var ent = TEMP.get();
			if (ent == null) return;
			var owner = arrow.getOwner();
			if (owner != null && ent.user == owner && ent.tickCount == owner.tickCount) {
				arrow.getPersistentData().put("Celestial-BowInfo", ent.stack.serializeNBT());
			}
		}
	}

	static ItemStack getBowInfo(Arrow arrow) {
		var root = arrow.getPersistentData();
		if (!root.contains("Celestial-BowInfo", Tag.TAG_COMPOUND)) return ItemStack.EMPTY;
		return ItemStack.of(root.getCompound("Celestial-BowInfo"));
	}

}
