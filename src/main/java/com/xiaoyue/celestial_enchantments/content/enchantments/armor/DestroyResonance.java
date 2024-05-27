package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class DestroyResonance extends DefenceEnch {

  private static double damage() {
	  return 0.1;
	}

	public DestroyResonance() {
		super(Rarity.RARE, Type.ARMOR, EnchData.special(3, REACTIVE));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		if (user.getLastDamageSource() == null) return;
		List<LivingEntity> others = EntityUtils.getDelimitedMonster(user, 6);
		others.remove(user);
		for (LivingEntity list : others) {
			DamageSource source = new DamageSource(user.getLastDamageSource().typeHolder());
			GeneralEventHandler.schedule(() -> list.hurt(source, lv * (float) damage() * cache.getPreDamage()));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, damage(), alt));
	}


}