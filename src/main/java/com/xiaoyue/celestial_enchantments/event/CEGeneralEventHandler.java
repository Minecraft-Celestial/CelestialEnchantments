package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.content.generic.*;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import dev.xkmc.l2core.init.reg.ench.LegacyEnchantment;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.player.ArrowLooseEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

@EventBusSubscriber(modid = MODID)
public class CEGeneralEventHandler {

	@SubscribeEvent
	public static void onItemAttributes(ItemAttributeModifierEvent event) {
		ItemStack stack = event.getItemStack();
		if (stack.isEnchanted()) {
			for (var ent : EnchantmentHelper.getEnchantmentsForCrafting(stack).entrySet()) {
				var attr = LegacyEnchantment.firstOf(ent.getKey(), AttributeEnchantment.class);
				if (attr != null) {
					attr.addAttributes(ent.getIntValue(), event);
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
		event.getOrb().value = (int) (event.getOrb().value * Math.max(0, val));
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
	public static void onShieldBlock(LivingShieldBlockEvent event) {
		if (event.getDamageSource().getEntity() instanceof LivingEntity attacker) {
			for (var entry : IEnchUtils.getHeldEnch(event.getEntity()).entrySet()) {
				if (entry.getKey() instanceof ShieldEnch ench) {
					ench.onShieldBlock(event, attacker, event.getEntity(), entry.getValue());
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingTick(EntityTickEvent.Post event) {
		if (!(event.getEntity() instanceof LivingEntity entity)) return;
		if (event.getEntity().tickCount % 4 != 0) return;
		for (var entry : IEnchUtils.getAllEnch(entity).entrySet()) {
			if (entry.getKey() instanceof LivingTickEnch ench) {
				ench.onLivingTick(event, entity, entry.getValue());
			}
		}
		for (var e : EquipmentSlot.values()) {
			ItemStack stack = entity.getItemBySlot(e);
			if (stack.isEnchanted()) {
				for (var holder : LegacyEnchantment.findAll(stack, CEBaseEnchantment.class, true)) {
					if (holder.val().isEnabled() && holder.val() instanceof ToolTickEnch tick) {
						tick.onLivingTick(event, stack, holder.lv());
					}
				}
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
				arrow.getPersistentData().put("Celestial-BowInfo", ent.stack.save(arrow.level().registryAccess()));
				TEMP.remove();
			}
		}
	}

	static ItemStack getBowInfo(Arrow arrow) {
		var root = arrow.getPersistentData();
		if (!root.contains("Celestial-BowInfo", Tag.TAG_COMPOUND)) return ItemStack.EMPTY;
		return ItemStack.parseOptional(arrow.level().registryAccess(), root.getCompound("Celestial-BowInfo"));
	}

}
