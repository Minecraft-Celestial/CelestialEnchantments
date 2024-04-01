
package com.xiaoyue.celestial_enchantments.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.effects.Corruption;
import com.xiaoyue.celestial_enchantments.content.effects.Destructed;
import com.xiaoyue.celestial_enchantments.content.effects.Suppressed;
import net.minecraft.world.effect.MobEffect;

public class CEEffects {

	public static final RegistryEntry<Corruption> CORRUPTION = genEffect("corruption", Corruption::new, "Reduce armor");
	public static final RegistryEntry<Destructed> DESTRUCTED = genEffect("destructed", Destructed::new, "Remove invulnerable time after hit");
	public static final RegistryEntry<Suppressed> SUPPRESSED = genEffect("suppressed", Suppressed::new, "Prevents healing");

	public CEEffects() {
	}

	private static <T extends MobEffect> RegistryEntry<T> genEffect(String name, NonNullSupplier<T> sup, String desc) {
		return CelestialEnchantments.REGISTRATE.effect(name, sup, desc).lang(MobEffect::getDescriptionId).register();
	}

	public static void register() {
	}

}
