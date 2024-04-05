package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.content.generic.WeaponEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LightLayer;

public class ShadowTouch extends WeaponEnch {

	public ShadowTouch() {
		super(Rarity.VERY_RARE, EnchData.special(5, A300));
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
