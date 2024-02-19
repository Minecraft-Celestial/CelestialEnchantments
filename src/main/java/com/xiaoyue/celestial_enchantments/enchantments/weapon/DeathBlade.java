package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.config.CommonConfig;
import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DeathBlade extends CAttackEnch {
    public DeathBlade() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
            float maxHealth = target.getMaxHealth();
            float min = Math.min(event.getAmount() + (maxHealth * 0.05f * level), level * CommonConfig.DEATH_BLADE_MAX_ADD_DAMAGE.get());
            event.setAmount(min);
        }
    }
}
