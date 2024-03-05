package com.xiaoyue.celestial_enchantments.enchantments.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.xiaoyue.celestial_enchantments.generic.DefenceEnch;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class CorruptionBody extends DefenceEnch {

	public CorruptionBody() {
		super(Rarity.UNCOMMON, Type.LEGS);
	}

	@Override
	public int getMinCost(int level) {
		return (level * 6) - 1;
	}

	@Override
	public int getMaxCost(int level) {
		return 1 + (level * 6);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	private Multimap<Attribute, AttributeModifier> createAttributeMap(int level) {
		Multimap<Attribute, AttributeModifier> attributesDefault = HashMultimap.create();
		attributesDefault.put(Attributes.ARMOR, new AttributeModifier(UUID.fromString("1-2-3-4-5"), "cbam", -(level * 2), AttributeModifier.Operation.ADDITION));
		return attributesDefault;
	}

	@Override
	public void doPostHurt(LivingEntity entity, Entity attacker, int level) {
		if (attacker instanceof LivingEntity livingEntity) {

			livingEntity.getAttributes().addTransientAttributeModifiers(this.createAttributeMap(level));
		}
	}
}
