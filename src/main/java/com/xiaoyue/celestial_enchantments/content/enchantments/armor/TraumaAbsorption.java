package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.world.entity.LivingEntity;

public class TraumaAbsorption extends DefenceEnch {

	public TraumaAbsorption() {
		super(Rarity.RARE, Type.CHEST, EnchData.treasure(5, PROTECT));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		user.heal((user.getMaxHealth() - user.getHealth()) * 0.09f);
	}

}
