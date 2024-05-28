package com.xiaoyue.celestial_enchantments.content.effects;

import com.xiaoyue.celestial_enchantments.data.CELang;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public interface EnchEffectEntry {

	MobEffectInstance ins(int lv);

	MutableComponent comp(int lv, boolean alt);

	static EnchEffectEntry all(Supplier<MobEffect> eff, IntSupplier dur) {
		return new All(eff, dur);
	}

	static EnchEffectEntry dur(Supplier<MobEffect> eff, IntSupplier dur, IntSupplier level) {
		return new Dur(eff, dur, level);
	}

	static EnchEffectEntry amp(Supplier<MobEffect> eff, IntSupplier dur) {
		return new Amp(eff, dur,1);
	}

	static EnchEffectEntry amp(Supplier<MobEffect> eff, IntSupplier dur, int factor) {
		return new Amp(eff, dur,factor);
	}

	record All(Supplier<MobEffect> eff, IntSupplier dur) implements EnchEffectEntry {

		@Override
		public MobEffectInstance ins(int lv) {
			return new MobEffectInstance(eff.get(), dur.getAsInt() * 20 * lv, lv - 1);
		}

		@Override
		public MutableComponent comp(int lv, boolean alt) {
			return !alt ? CELang.eff(ins(lv)) : CELang.EFF_ALL.get(
					CELang.eff(ins(lv), false, false),
					CELang.num(lv, dur.getAsInt(), true),
					CELang.num(lv, 1, true));
		}

	}

	record Dur(Supplier<MobEffect> eff, IntSupplier dur, IntSupplier level) implements EnchEffectEntry {

		@Override
		public MobEffectInstance ins(int lv) {
			return new MobEffectInstance(eff.get(), dur.getAsInt() * 20 * lv, level.getAsInt());
		}

		@Override
		public MutableComponent comp(int lv, boolean alt) {
			return !alt ? CELang.eff(ins(lv)) : CELang.EFF_DUR.get(
					CELang.eff(ins(lv), true, false),
					CELang.num(lv, dur.getAsInt(), true));
		}

	}

	record Amp(Supplier<MobEffect> eff, IntSupplier dur, int factor) implements EnchEffectEntry {

		@Override
		public MobEffectInstance ins(int lv) {
			return new MobEffectInstance(eff.get(), dur.getAsInt() * 20, lv * factor - 1);
		}

		@Override
		public MutableComponent comp(int lv, boolean alt) {
			return !alt ? CELang.eff(ins(lv)) : CELang.EFF_AMP.get(
					CELang.eff(ins(lv), false, true),
					CELang.num(lv, factor, true));
		}

	}

}
