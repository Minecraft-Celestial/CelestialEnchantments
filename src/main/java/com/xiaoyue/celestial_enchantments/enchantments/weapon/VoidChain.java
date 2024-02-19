package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class VoidChain extends CAttackEnch {

    public VoidChain() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 8) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 8);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.SWEEPING_EDGE;
    }

    @Override
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            event.setAmount(event.getAmount() * 0.1f);
            List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(attacker, 6, 2);
            for (LivingEntity list : entities) {
                list.hurt(attacker.damageSources().mobAttack(attacker), event.getAmount() * (0.5f * level));
            }
        }
    }
}
