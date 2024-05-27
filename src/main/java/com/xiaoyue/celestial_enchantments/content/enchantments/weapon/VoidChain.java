package com.xiaoyue.celestial_enchantments.content.enchantments.weapon;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_core.utils.EntityUtils;
import com.xiaoyue.celestial_enchantments.content.generic.AttackEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;

public class VoidChain extends AttackEnch {

	private static double spread() {
		return 0.1;
	}

	private static int radius() {
		return 6;
	}

	public VoidChain() {
		super(Rarity.UNCOMMON, EnchData.special(3, A300));
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && enchantment != Enchantments.SWEEPING_EDGE;
	}

	@Override
	public void onDamageTargetFinal(LivingEntity user, LivingEntity target, AttackCache cache, int lv) {
		List<LivingEntity> entities = EntityUtils.getExceptForCentralEntity(user, radius(), 2);
		for (LivingEntity list : entities) {
			list.hurt(CCDamageTypes.abyss(user), cache.getDamageDealt() * lv * (float) spread());
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.perc(lv, spread(), alt));
	}

}
