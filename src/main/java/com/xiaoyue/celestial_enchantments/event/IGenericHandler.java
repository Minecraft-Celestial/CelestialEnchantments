package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import com.xiaoyue.celestial_enchantments.generic.intf.*;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.Set;

public class IGenericHandler {

    @SubscribeEvent
    public void onItemModify(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEnchanted()) {
            Set<Map.Entry<Enchantment, Integer>> entries = EnchantmentHelper.getEnchantments(stack).entrySet();
            for (Map.Entry<Enchantment, Integer> map : entries) {
                if (map.getKey() instanceof ItemModifyEnch itemModifyEnch) {
                    itemModifyEnch.modifyAttribute(event, stack, map.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void onPLayerBreak(PlayerEvent.BreakSpeed event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof PlayerBreakEnch ench) {
                ench.onBreakSpeed(event, event.getEntity(), event.getState(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onPickupXp(PlayerXpEvent.PickupXp event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof ChangeXpEnch ench) {
                ench.onPickupXp(event, event.getEntity(), entry.getValue(), event.getOrb());
            }
        }
    }

    @SubscribeEvent
    public void onLivingHeal(LivingHealEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof LivingHealEnch ench) {
                ench.onLivingHeal(event, event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onShieldBlock(ShieldBlockEvent event) {
        if (event.getDamageSource().getEntity() instanceof LivingEntity attacker) {
            for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
                if (entry.getKey() instanceof ShieldBlockEnch ench) {
                    ench.onShieldBlock(event, attacker, event.getEntity(), entry.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingTick(LivingEvent.LivingTickEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof LivingTickEnch ench) {
                ench.onLivingTick(event, event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onUnderAttack(LivingAttackEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof CAttackEnch ench) {
                ench.onUnderAttack(event, event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onUnderHurt(LivingHurtEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof CAttackEnch ench) {
                ench.onUnderHurt(event, event.getSource().getEntity(), event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onUnderDamage(LivingDamageEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof CAttackEnch ench) {
                ench.onUnderDamage(event, event.getSource().getEntity(), event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onUnderDeath(LivingDeathEvent event) {
        for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(event.getEntity())) {
            if (entry.getKey() instanceof CAttackEnch ench) {
                ench.onUnderDeath(event, event.getSource().getEntity(), event.getEntity(), entry.getValue());
            }
        }
    }

    @SubscribeEvent
    public void onAttackEntity(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(attacker)) {
                if (entry.getKey() instanceof CAttackEnch ench) {
                    ench.onAttackEntity(event, attacker, event.getEntity(), entry.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void onHurtEntity(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(attacker)) {
                if (entry.getKey() instanceof CAttackEnch ench) {
                    ench.onHurtEntity(event, attacker, event.getEntity(), entry.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void onDamageEntity(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(attacker)) {
                if (entry.getKey() instanceof CAttackEnch ench) {
                    ench.onDamageEntity(event, attacker, event.getEntity(), entry.getValue());
                }
            }
        }
    }

    @SubscribeEvent
    public void onKillEntity(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Map.Entry<Enchantment, Integer> entry : IEnchUtils.getAllSlotsEnch(attacker)) {
                if (entry.getKey() instanceof CAttackEnch ench) {
                    ench.onKillEntity(event, attacker, event.getEntity(), entry.getValue());
                }
            }
        }
    }
}
