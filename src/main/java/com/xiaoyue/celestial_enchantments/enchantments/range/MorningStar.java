package com.xiaoyue.celestial_enchantments.enchantments.range;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class MorningStar extends XCEnchBase {
    public MorningStar() {
        super(Rarity.RARE, EnchantmentCategory.BOW, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
    protected boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.FLAMING_ARROWS;
    }

    @Override
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity entity, int level) {
        if (entity instanceof LivingEntity livingEntity) {
            for (int i = 0; i < level; i++) {
                if (Math.random() > 0.5) {
                    EntityUtils.spawnThunder(livingEntity);
                }
            }
        }
    }
}