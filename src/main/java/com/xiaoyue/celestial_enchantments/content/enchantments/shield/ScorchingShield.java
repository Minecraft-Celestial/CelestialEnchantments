package com.xiaoyue.celestial_enchantments.content.enchantments.shield;

import com.xiaoyue.celestial_enchantments.content.generic.ShieldEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ScorchingShield extends ShieldEnch {

  private static int fireTime() {
		return 20;
	}

	public ScorchingShield() {
		super(Rarity.RARE, EnchData.normal(3, SHIELD));
	}

	@Override
	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		attacker.setSecondsOnFire(level * fireTime());
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, fireTime(), alt));
	}

}
