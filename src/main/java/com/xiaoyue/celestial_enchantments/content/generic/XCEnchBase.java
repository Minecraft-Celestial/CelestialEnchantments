package com.xiaoyue.celestial_enchantments.content.generic;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2library.base.L2Registrate;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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

	public static final EnchGroup CURSE = EnchGroup.simple(ChatFormatting.RED);

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

	private final EnchData config;
	public Set<EquipmentSlot> slots;


	XCEnchBase(Rarity rarity, Type type, EnchData config) {
		super(rarity, type.category, type.slots);
		this.slots = Set.of(type.slots);
		this.config = config;
		CACHE.add(this);
	}

	public Component desc(int lv, String key, boolean alt) {
		return Component.translatable(key).withStyle(ChatFormatting.DARK_GRAY);
	}

	protected boolean chance(LivingEntity e, double chance) {
		return e.getRandom().nextDouble() < chance;
	}

	@Override
	public final int getMaxLevel() {
		return config.level().maxLv();
	}

	@Override
	public final int getMinCost(int pLevel) {
		return config.level().getMinCost(pLevel);
	}

	@Override
	public final int getMaxCost(int pLevel) {
		return config.level().getMaxCost(pLevel);
	}

	@Override
	public final boolean isTreasureOnly() {
		return config.level().isTreasure();
	}

	@Override
	public final boolean isCurse() {
		return config.level().curse();
	}

	@Override
	public final boolean isDiscoverable() {
		return super.isDiscoverable() && config.level().discoverable();
	}

	@Override
	public final boolean isTradeable() {
		return false;
	}

	protected boolean checkCompatibility(Enchantment other) {
		if (other instanceof XCEnchBase base) {
			return config.group().multi() || config.group() != base.config.group();
		} else {
			return config.group().compatible(other);
		}
	}

}
