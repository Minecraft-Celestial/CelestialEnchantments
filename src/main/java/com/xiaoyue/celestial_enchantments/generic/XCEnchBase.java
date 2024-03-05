package com.xiaoyue.celestial_enchantments.generic;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.base.L2Registrate;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class XCEnchBase extends Enchantment {

	private static final List<XCEnchBase> CACHE = new ArrayList<>();

	public static ItemStack makeBook(Enchantment ench, int level) {
		return EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ench, level));
	}

	public static void injectTab(L2Registrate reg) {
		reg.modifyCreativeModeTab(CelestialEnchantments.TAB_ENCHMIN.getKey(), (m) -> CACHE.forEach((e) ->
				m.accept(makeBook(e, 1), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY)));
		reg.modifyCreativeModeTab(CelestialEnchantments.TAB_ENCHMAX.getKey(), (m) -> CACHE.forEach((e) ->
				m.accept(makeBook(e, e.getMaxLevel()), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY)));
	}

	protected enum Type {
		ALL(EnchantmentCategory.BREAKABLE, EquipmentSlot.values()),
		WEAPON(EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND),
		DIGGER(EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND),
		TRIDENT(EnchantmentCategory.TRIDENT, EquipmentSlot.MAINHAND),
		HOE(IEnchUtils.HOE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND),
		BOW(IEnchUtils.BOW_AND_CROSSBOW, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND),
		SHIELD(IEnchUtils.SHIELD, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND),
		ARMOR(EnchantmentCategory.ARMOR, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET),
		HEAD(EnchantmentCategory.ARMOR_HEAD, EquipmentSlot.HEAD),
		CHEST(EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.CHEST),
		LEGS(EnchantmentCategory.ARMOR_LEGS, EquipmentSlot.LEGS),
		FEET(EnchantmentCategory.ARMOR_FEET, EquipmentSlot.FEET),
		;

		private final EnchantmentCategory category;
		private final EquipmentSlot[] slots;

		Type(EnchantmentCategory category, EquipmentSlot... slots) {
			this.category = category;
			this.slots = slots;
		}
	}

	public static DamageSource getSource(AttackCache cache) {
		var event = cache.getLivingAttackEvent();
		assert event != null;
		return event.getSource();
	}

	public Set<EquipmentSlot> slots;

	XCEnchBase(Rarity rarity, Type type) {
		super(rarity, type.category, type.slots);
		this.slots = Set.of(type.slots);
		CACHE.add(this);
	}

	protected boolean chance(LivingEntity e, double chance) {
		return e.getRandom().nextDouble() < chance;
	}

	@Override
	public int getMinCost(int pLevel) {
		return super.getMinCost(pLevel);
	}

	@Override
	public int getMaxCost(int pLevel) {
		return super.getMaxCost(pLevel);
	}

	@Override
	public boolean isTreasureOnly() {
		return super.isTreasureOnly();
	}

	@Override
	public boolean isTradeable() {
		return super.isTradeable();
	}

}
