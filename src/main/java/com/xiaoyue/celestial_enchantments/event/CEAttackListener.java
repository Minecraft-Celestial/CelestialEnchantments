package com.xiaoyue.celestial_enchantments.event;

import com.xiaoyue.celestial_enchantments.generic.*;
import com.xiaoyue.celestial_enchantments.mixin.MixinTrident;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.AttackListener;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class CEAttackListener implements AttackListener {

	@Override
	public void onAttack(AttackCache cache, ItemStack weapon) {
		var target = cache.getAttackTarget();
		var map = IEnchUtils.getArmorEnch(target);
		for (var ent : map.entrySet()) {
			if (ent.getKey() instanceof DefenceEnch def) {
				if (def.onAttacked(target, cache, ent.getValue())) {
					var event = cache.getLivingAttackEvent();
					assert event != null;
					event.setCanceled(true);
					return;
				}
			}
		}
	}

	@Override
	public void onHurt(AttackCache cache, ItemStack weapon) {
		var user = cache.getAttacker();
		var target = cache.getAttackTarget();
		if (XCEnchBase.getSource(cache).getDirectEntity() instanceof Arrow arrow) {
			ItemStack bow = CEGeneralEventHandler.getBowInfo(arrow);
			if (bow.isEnchanted()) {
				for (var ent : EnchantmentHelper.getEnchantments(bow).entrySet()) {
					if (ent.getKey() instanceof BowEnch attr) {
						attr.hurtTarget(arrow, target, ent.getValue(), cache);
					}
				}
			}
		} else if (XCEnchBase.getSource(cache).getDirectEntity() instanceof ThrownTrident trident) {
			ItemStack item = ((MixinTrident) trident).getTridentItem();
			if (item.isEnchanted()) {
				for (var ent : EnchantmentHelper.getEnchantments(item).entrySet()) {
					if (ent.getKey() instanceof TridentEnch attr) {
						attr.hurtTarget(trident, target, ent.getValue(), cache);
					}
				}
			}
		} else if (user != null) {
			var map = IEnchUtils.getEnch(user, EquipmentSlot.MAINHAND);
			for (var ent : map.entrySet()) {
				if (ent.getKey() instanceof AttackEnch atk) {
					atk.onHurtTarget(user, target, cache, ent.getValue());
				}
			}
		}
	}

	@Override
	public void onDamage(AttackCache cache, ItemStack weapon) {
		var target = cache.getAttackTarget();
		var map = IEnchUtils.getArmorEnch(target);
		for (var ent : map.entrySet()) {
			if (ent.getKey() instanceof DefenceEnch def) {
				def.onDamaged(target, cache, ent.getValue());
			}
		}
	}

	@Override
	public void onDamageFinalized(AttackCache cache, ItemStack weapon) {
		var user = cache.getAttacker();
		var target = cache.getAttackTarget();
		if (XCEnchBase.getSource(cache).getDirectEntity() instanceof Arrow arrow) {
			ItemStack bow = CEGeneralEventHandler.getBowInfo(arrow);
			if (bow.isEnchanted()) {
				for (var ent : EnchantmentHelper.getEnchantments(bow).entrySet()) {
					if (ent.getKey() instanceof BowEnch attr) {
						attr.onDamageTargetFinal(arrow, target, ent.getValue(), cache);
					}
				}
			}
		} else if (user != null) {
			var map = IEnchUtils.getEnch(user, EquipmentSlot.MAINHAND);
			for (var ent : map.entrySet()) {
				if (ent.getKey() instanceof AttackEnch atk) {
					atk.onDamageTargetFinal(user, target, cache, ent.getValue());
				}
			}
		}
		var map = IEnchUtils.getArmorEnch(target);
		for (var ent : map.entrySet()) {
			if (ent.getKey() instanceof DefenceEnch def) {
				def.onDamagedFinal(target, cache, ent.getValue());
			}
		}
	}
}
