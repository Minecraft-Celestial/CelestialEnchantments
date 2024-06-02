package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LightLayer;

public class ShadowTouch extends AttackEnch {

	private static int brightness() {
		return CEModConfig.COMMON.ench.weapon.shadowTouchBrightness.get();
	}

	private static int factor() {
		return CEModConfig.COMMON.ench.weapon.shadowTouchDamage.get();
	}

	public ShadowTouch() {
		super(Rarity.UNCOMMON, EnchData.special(5, A300));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		if (!user.level().isClientSide()) {
			int brightness = user.level().getBrightness(LightLayer.BLOCK, user.blockPosition());
			if (brightness <= brightness()) {
				GeneralEventHandler.schedule(() -> target.hurt(CCDamageTypes.abyss(user), lv * factor()));
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(brightness()), CELang.num(lv, factor(), alt));
	}

}
