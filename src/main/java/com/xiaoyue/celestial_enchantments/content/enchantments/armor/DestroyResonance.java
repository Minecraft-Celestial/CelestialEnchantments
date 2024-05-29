package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class DestroyResonance extends DefenceEnch {

	private static double damage() {
		return CEModConfig.COMMON.ench.armor.destroyResonanceDamage.get();
	}

	private static int radius() {
		return CEModConfig.COMMON.ench.armor.destroyResonanceRadius.get();
	}

	public DestroyResonance() {
		super(Rarity.RARE, Type.ARMOR, EnchData.special(3, REACTIVE));
	}

	@Override
	public void onDamagedFinal(LivingEntity user, AttackCache cache, int lv) {
		var source = getSource(cache);
		if (source.is(DamageTypeTags.BYPASSES_COOLDOWN)) return;
		List<LivingEntity> others = EntityUtils.getDelimitedMonster(user, radius());
		others.remove(user);
		for (LivingEntity lest : others) {
			if (source.is(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && lest == cache.getAttacker()) continue;
			GeneralEventHandler.schedule(() -> lest.hurt(source, lv * (float) damage() * cache.getPreDamage()));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, damage(), alt), CELang.num(radius()));
	}


}