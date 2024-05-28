package com.xiaoyue.celestial_enchantments.content.enchantments.curse;

import com.xiaoyue.celestial_enchantments.content.generic.GeneralEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolTickEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

public class CorrosionCurse extends GeneralEnch implements ToolTickEnch {

	private static int dur() {
		return 5;
	}

	private static int lose() {
		return 1;
	}

	public CorrosionCurse() {
		super(Rarity.RARE, EnchData.curse(5));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, ItemStack stack, int level) {
		var entity = event.getEntity();
		if (entity.level().isClientSide()) return;
		if (entity.tickCount % (dur() * 20) == 0) {
			int max = stack.getMaxDamage() / 2;
			int dur = stack.getDamageValue();
			if (dur < max)
				stack.setDamageValue(Math.min(max, dur + lose() * level));
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(lv, lose(), alt), CELang.num(dur()));
	}

}
