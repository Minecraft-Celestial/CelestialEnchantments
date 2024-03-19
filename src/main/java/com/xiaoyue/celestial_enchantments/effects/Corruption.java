package com.xiaoyue.celestial_enchantments.effects;

import dev.xkmc.l2library.util.math.MathHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class Corruption extends MobEffect {

	public Corruption() {
		super(MobEffectCategory.HARMFUL, 16750848);
		String uuid = MathHelper.getUUIDFromString("celestial_enchantments:soul_shatter").toString();
		this.addAttributeModifier(Attributes.ARMOR, uuid, -3.0, AttributeModifier.Operation.ADDITION);
	}

}