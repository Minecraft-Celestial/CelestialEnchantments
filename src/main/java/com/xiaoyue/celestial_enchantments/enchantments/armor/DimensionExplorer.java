package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class DimensionExplorer extends XCEnchBase {
    public DimensionExplorer() {
        super(Rarity.RARE, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
        MinecraftForge.EVENT_BUS.addListener(this::onLevelChange);
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

    public void onLevelChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player entity = event.getEntity();
        int level = EnchantmentHelper.getEnchantmentLevel(this, entity);
        if (level > 0) {
            EntityUtils.addEct(entity, MobEffects.LUCK, 600, level - 1);
            EntityUtils.addEct(entity, MobEffects.DAMAGE_BOOST, 600, level - 1);
            EntityUtils.addEct(entity, MobEffects.DIG_SPEED, 600, level - 1);
        }
    }
}
