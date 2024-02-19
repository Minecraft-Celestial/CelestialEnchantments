package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.generic.intf.ChangeXpEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

public class CorruptScholar extends XCEnchBase implements ChangeXpEnch {
    public CorruptScholar() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
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
    public void onPickupXp(PlayerXpEvent.PickupXp event, Player player, int level, ExperienceOrb Orb) {
        if (level > 0) {
            int value = Orb.getValue();
            player.giveExperiencePoints((int) (value * (level * 0.8f)));
            if (Math.random() < 0.25 * level) {
                if (Math.random() < 0.3) {
                    EntityUtils.addEct(player, MobEffects.POISON, 100, 0);
                } else if (Math.random() > 0.3 && Math.random() < 0.7) {
                    EntityUtils.addEct(player, MobEffects.WITHER, 100, 0);
                } else {
                    EntityUtils.addEct(player, MobEffects.WEAKNESS, 100, 0);
                }
            }
        }
    }
}
