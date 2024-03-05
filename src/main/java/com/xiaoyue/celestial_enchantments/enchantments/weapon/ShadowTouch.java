package com.xiaoyue.celestial_enchantments.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.LightLayer;

public class ShadowTouch extends WeaponEnch {

	public ShadowTouch() {
		super(Rarity.VERY_RARE);
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
	public void doPostAttack(LivingEntity attacker, Entity target, int lv) {
		if (target instanceof LivingEntity user) {
			if (!attacker.level().isClientSide()) {
				int brightness = attacker.level().getBrightness(LightLayer.BLOCK, attacker.blockPosition());
				if (brightness <= 5) {
					GeneralEventHandler.schedule(() -> user.hurt(CCDamageTypes.abyss(user), lv));
				}
			}
		}
	}
}
