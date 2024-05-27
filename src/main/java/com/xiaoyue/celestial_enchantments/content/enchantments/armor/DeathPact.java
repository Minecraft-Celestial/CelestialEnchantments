package com.xiaoyue.celestial_enchantments.content.enchantments.armor;

import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.effects.EnchEffectEntry;
import com.xiaoyue.celestial_enchantments.content.generic.DeathEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.List;

public class DeathPact extends DeathEnch {

	private static int radius() {
		return 12;
	}

	private static double chance() {
		return 0.2;
	}

	private static int dur() {
		return 10;
	}

	private static final EnchEffectEntry EFF0 = EnchEffectEntry.dur(() -> MobEffects.DAMAGE_RESISTANCE, DeathPact::dur, () -> 1);
	private static final EnchEffectEntry EFF1 = EnchEffectEntry.dur(() -> MobEffects.ABSORPTION, DeathPact::dur, () -> 2);
	private static final EnchEffectEntry EFF2 = EnchEffectEntry.dur(() -> MobEffects.DAMAGE_BOOST, DeathPact::dur, () -> 1);
	private static final EnchEffectEntry EFF3 = EnchEffectEntry.dur(() -> MobEffects.MOVEMENT_SPEED, DeathPact::dur, () -> 2);

	public DeathPact() {
		super(Rarity.UNCOMMON, Type.CHEST, EnchData.bad(5, DEATH));
	}

	@Override
	public void onDeath(LivingEntity entity, int level) {
		if (entity.level().isClientSide()) return;
		if (entity instanceof Player player) {
			List<LivingEntity> list = EntityUtils.getExceptForCentralEntity(player, radius(), 2, livingEntity -> livingEntity instanceof Player);
			for (LivingEntity pl : list) {
				int lv = EnchantmentHelper.getEnchantmentLevel(this, pl);
				if (chance(entity, lv * chance())) {
					pl.kill();
				} else {
					pl.addEffect(EFF0.ins(level));
					pl.addEffect(EFF1.ins(level));
					pl.addEffect(EFF2.ins(level));
					pl.addEffect(EFF3.ins(level));
				}
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, getName(), CELang.perc(lv, chance(), alt),
				EFF0.comp(lv, alt), EFF1.comp(lv, alt),
				EFF2.comp(lv, alt), EFF3.comp(lv, alt));
	}

}
