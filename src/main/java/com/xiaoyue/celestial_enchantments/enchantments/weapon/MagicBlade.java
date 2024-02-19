package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.utils.IAttackUtils;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class MagicBlade extends CAttackEnch {
    public MagicBlade() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public void onDamageEntity(LivingDamageEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            IAttackUtils.attackEntitySecondary(attacker.damageSources().magic(), event.getAmount(), target);
        }
    }
}
