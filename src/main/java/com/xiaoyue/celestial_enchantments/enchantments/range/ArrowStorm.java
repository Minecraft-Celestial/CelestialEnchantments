package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class ArrowStorm extends CAttackEnch {
    public ArrowStorm() {
        super(Rarity.RARE, IEnchUtils.BOW_AND_CROSSBOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
            float amount = event.getAmount();
            event.setAmount(amount * (1 - (level * 0.05f)));
            if (event.getSource().getDirectEntity() instanceof AbstractArrow arrow) {
            List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(target, 5, 2);
                for (LivingEntity list : entities) {
                    DamageSource damageSource = new DamageSource(attacker.damageSources().arrow(arrow, attacker).typeHolder());
                    list.hurt(damageSource, amount * (level * 0.1f));
                }
            }
        }
    }
}
