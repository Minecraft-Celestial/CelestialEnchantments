package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_enchantments.generic.CAttackEnch;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class WordsOfWisdom extends CAttackEnch {

    public WordsOfWisdom() {
        super(Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return (level * 10) - 1;
    }

    @Override
    public int getMaxCost(int level) {
        return 1 + (level * 10);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onHurtEntity(LivingHurtEvent event, LivingEntity attacker, LivingEntity target, int level) {
        if (level > 0) {
            if (attacker instanceof Player player) {
                int experienceLevel = player.experienceLevel;
                float i = ((float) experienceLevel / 5) * 0.05f;
                float min = Math.min(i, 0.2f * level);
                event.setAmount(event.getAmount() * (1 + min));
            }
        }
    }
}
