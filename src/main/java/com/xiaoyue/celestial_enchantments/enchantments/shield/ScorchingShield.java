package com.xiaoyue.celestial_enchantments.enchantments.shield;

import com.xiaoyue.celestial_enchantments.generic.intf.ShieldBlockEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ScorchingShield extends XCEnchBase implements ShieldBlockEnch {
    public ScorchingShield() {
        super(Rarity.RARE, IEnchUtils.SHIELD, IEnchUtils.MAIN_AND_OFF);
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
    public boolean isTradeable() {
        return super.isTradeable();
    }

    @Override
    public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
        if (level > 0) {
            attacker.setSecondsOnFire(level * 20);
        }
    }
}
