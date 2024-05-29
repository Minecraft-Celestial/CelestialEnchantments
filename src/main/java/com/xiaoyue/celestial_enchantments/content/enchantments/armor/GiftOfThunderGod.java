package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.DefenceEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class GiftOfThunderGod extends DefenceEnch {

	private static double heal() {
		return CEModConfig.COMMON.ench.armor.giftOfThunderGodHeal.get();
	}

	private static int duration() {
		return CEModConfig.COMMON.ench.armor.giftOfThunderGodDuration.get();
	}

	private static final EnchEffectEntry MOVE = EnchEffectEntry.amp(() -> MobEffects.MOVEMENT_SPEED, GiftOfThunderGod::duration);
	private static final EnchEffectEntry RES = EnchEffectEntry.amp(() -> MobEffects.DAMAGE_RESISTANCE, GiftOfThunderGod::duration);

	public GiftOfThunderGod() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchData.treasure(3, EFFECT));
	}

	@Override
	public boolean onAttackedImpl(LivingEntity user, AttackCache cache, int lv) {
		if (getSource(cache).is(DamageTypeTags.IS_LIGHTNING)) {
			user.heal(lv * (float) heal() * (user.getMaxHealth() - user.getHealth()));
			user.addEffect(MOVE.ins(lv));
			user.addEffect(RES.ins(lv));
			return true;
		}
		return false;
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, heal(), alt), MOVE.comp(lv, alt), RES.comp(lv, alt));
	}
}
