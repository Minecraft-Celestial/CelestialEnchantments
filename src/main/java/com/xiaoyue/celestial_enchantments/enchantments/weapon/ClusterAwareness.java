package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class ClusterAwareness extends CAttackEnch {
    public ClusterAwareness() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 6) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 6);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            if (attacker instanceof Monster monster) {
                List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(monster, 6, 2, livingEntity -> livingEntity instanceof Monster);
                event.setAmount(event.getAmount() * 1 + ((level * 0.12f) * entities.size()));
            }
            if (attacker instanceof Player player) {
                List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(player, 6, 2, livingEntity -> livingEntity instanceof Player);
                event.setAmount(event.getAmount() * 1 + ((level * 0.12f) * entities.size()));
            }
        }
    }
}
