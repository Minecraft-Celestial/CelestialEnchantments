package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DivineEjaculation extends CAttackEnch {
    public DivineEjaculation() {
        super(Rarity.VERY_RARE, IEnchUtils.BOW_AND_CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 25) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 28);
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }

    @Override
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            event.setAmount(event.getAmount() * (1 + (attacker.distanceTo(target) * 0.03f)));
        }
    }
}
