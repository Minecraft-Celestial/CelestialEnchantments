package com.xiaoyue.celestial_enchantments.content.enchantments.shield;

import com.xiaoyue.celestial_enchantments.content.generic.ShieldEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ReactiveBlock extends ShieldEnch {

	public ReactiveBlock() {
		super(Rarity.RARE, EnchData.normal(3, SHIELD));
	}

	@Override
	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		attacker.knockback(level * 0.5f, entity.getX() - attacker.getX(), entity.getZ() - attacker.getZ());
	}

}
