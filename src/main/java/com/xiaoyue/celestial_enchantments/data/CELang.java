package com.xiaoyue.celestial_enchantments.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;

import java.util.Locale;

public enum CELang {
	EFF_ALL("%2$s seconds of %1$s with level %3$s", 3),
	EFF_DUR("%2$s seconds of %1$s", 2),
	EFF_AMP("%1$s with level %2$s", 2),
	ALT("Press [%s] to show enchantment effect formula", 1),
	ECHO("Cooldown: %s seconds", 1),

	ITEM_COST( "1 %s",1),

	CELE("[Celestial]",0),
	NORMAL("[Basic]",0),
	ADVANCED("[Advanced]",0),
	LEGENDARY("[Legendary]",0),
	CURSE("[Curse]",0),
	DOUBLE("[Double-Edge]",0),

	GENERAL("[Generic]",0),
	UTILITY("[Utility]",0),
	SHIELD("[Shielding]",0),
	TRIDENT("[Trident]",0),
	ARROW("[Archery]",0),
	ARROW_EFFECT("[Dipped]",0),
	DEATH("[Death]",0),
	ARMOR_EFFECT("[Coating]",0),
	REACTIVE("[Reactive]",0),
	EXP("[Experience]",0),
	PROT("[Shelter]",0),
	INFLICT("[Infused]",0),
	BLADE("[Blade]",0),
	BERSERK("[Shredding]",0),
	EPIC("[Master]",0),

	HEAD("[Helmet]",0),
	CHEST("[Chestplate]",0),
	LEGS("[Leggings]",0),
	FEET("[Boots]",0),

	TABLE_DESC_0("Applies Celestial Enchantments to your tools. Consumes Celestial Catalysts.",0),
	TABLE_DESC_1("Enchanted books in Chiseled Bookshelves provide black list for enchanting, but decrease enchantment levels.",0),
	TABLE_DESC_CA("Chaotic Pendant and tools with high enchantment affinity will make rare enchantments more common, and reduce chance to produce curse enchantments",0)


	;

	private final String key, def;
	private final int arg;

	CELang(String def, int arg) {
		String id = name().toLowerCase(Locale.ROOT);
		this.key = CelestialEnchantments.MODID + ".tooltip." + id;
		this.def = def;
		this.arg = arg;
	}

	public MutableComponent get(MutableComponent... args) {
		if (args.length != arg)
			throw new IllegalArgumentException("for " + name() + ": expect " + arg + " parameters, got " + args.length);
		return Component.translatable(key, (Object[]) args);
	}

	public static MutableComponent perc(double val) {
		return Component.literal(Math.round(val * 100) + "%").withStyle(ChatFormatting.DARK_AQUA);
	}

	public static MutableComponent perc(int lv, double val, boolean alt) {
		return (alt ? Component.literal("[Lv]x" + (int) Math.round(val * 100) + "%") :
				Component.literal((int) Math.round(lv * val * 100) + "%"))
				.withStyle(ChatFormatting.DARK_AQUA);
	}

	public static MutableComponent percSmall(int lv, double val, boolean alt) {
		return (alt ? Component.literal("[Lv]x" + (int) Math.round(val * 10000) /100d + "%") :
				Component.literal((int) Math.round(lv * val * 10000) /100d + "%"))
				.withStyle(ChatFormatting.DARK_AQUA);
	}

	public static MutableComponent num(int val) {
		return Component.literal("" + val).withStyle(ChatFormatting.DARK_AQUA);
	}

	public static MutableComponent num(int lv, int val, boolean alt) {
		return (alt ? val == 1 ? Component.literal("[Lv]") : Component.literal("[Lv]x" + val) :
				Component.literal(lv * val + ""))
				.withStyle(ChatFormatting.DARK_AQUA);
	}

	public static Component ench(String key, MutableComponent... perc) {
		return Component.translatable(key, (Object[]) perc).withStyle(ChatFormatting.GRAY);
	}

	public static MutableComponent eff(MobEffectInstance ins) {
		return eff(ins, true, true);
	}

	public static MutableComponent eff(MobEffectInstance ins, boolean showLevel, boolean showDuration) {
		MutableComponent desc = Component.translatable(ins.getDescriptionId());
		if (showLevel && ins.getAmplifier() > 0) {
			desc = Component.translatable("potion.withAmplifier", desc,
					Component.translatable("potion.potency." + ins.getAmplifier()));
		}
		if (showDuration && !ins.endsWithin(19)) {
			desc = Component.translatable("potion.withDuration", desc, MobEffectUtil.formatDuration(ins, 1));
		}
		return desc.withStyle(ins.getEffect().getCategory().getTooltipFormatting());
	}

	public static MutableComponent eff(MobEffect eff) {
		return eff.getDisplayName().copy().withStyle(eff.getCategory().getTooltipFormatting());
	}

	public static MutableComponent alt() {
		return ALT.get(Component.literal("ALT").withStyle(ChatFormatting.YELLOW))
				.withStyle(ChatFormatting.GRAY);
	}

	public static void genLang(RegistrateLangProvider pvd) {
		for (var lang : values()) {
			pvd.add(lang.key, lang.def);
		}
	}

}
