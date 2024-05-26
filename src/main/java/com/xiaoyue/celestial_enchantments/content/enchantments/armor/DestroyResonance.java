package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.ArmorEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class DestroyResonance extends ArmorEnch {

  private static double damage() {
		return 2;
	}

	public DestroyResonance() {
		super(Rarity.RARE, Type.ARMOR,  EnchData.treasure(3, REACTIVE));
	}

	@Override
	public void doPostHurt(LivingEntity user, Entity attacker, int level) {
		if (user.getLastDamageSource() == null) return;
		List<LivingEntity> others = EntityUtils.getDelimitedMonster(user, 6);
		others.remove(user);
		for (LivingEntity list : others) {
			DamageSource source = new DamageSource(user.getLastDamageSource().typeHolder());
			GeneralEventHandler.schedule(() -> list.hurt(source, level * (float) damage()));
		}
	}

}