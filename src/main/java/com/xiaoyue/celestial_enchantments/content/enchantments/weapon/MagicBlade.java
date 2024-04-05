package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.entity.LivingEntity;

public class MagicBlade extends AttackEnch {

	public MagicBlade() {
		super(Rarity.RARE, EnchData.special(1, A300));
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		GeneralEventHandler.schedule(() -> target.hurt(CCDamageTypes.magic(user), cache.getDamageDealt()));
	}

}
