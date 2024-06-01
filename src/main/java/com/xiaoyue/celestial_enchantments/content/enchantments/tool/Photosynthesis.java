package com.xiaoyue.celestial_enchantments.content.enchantments.tool;

import com.xiaoyue.celestial_core.utils.CCUtils;
import com.xiaoyue.celestial_enchantments.content.generic.GeneralEnch;
import com.xiaoyue.celestial_enchantments.content.generic.ToolTickEnch;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.data.CEModConfig;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

public class Photosynthesis extends GeneralEnch implements ToolTickEnch {

	private static int dur() {
		return CEModConfig.COMMON.ench.tool.photosynthesisInterval.get();
	}

	private static int light() {
		return CEModConfig.COMMON.ench.tool.photosynthesisMinLight.get();
	}

	private static int recover() {
		return CEModConfig.COMMON.ench.tool.photosynthesisRecover.get();
	}

	public Photosynthesis() {
		super(Rarity.COMMON, EnchData.normal(5, DURABILITY));
	}

	@Override
	public void onLivingTick(LivingEvent.LivingTickEvent event, ItemStack stack, int level) {
		var entity = event.getEntity();
		if (entity.level().isClientSide()) return;
		if (entity.tickCount % (dur() * 20) == 0) {
			int brightness = CCUtils.getLight(entity.level(), entity.blockPosition());
			if (brightness >= light()) {
				stack.setDamageValue(Math.max(0, stack.getDamageValue() - recover() * level));
			}
		}
	}

	@Override
	public Component desc(int lv, String key, boolean alt) {
		return CELang.ench(key, CELang.num(light()), CELang.num(lv, recover(), alt), CELang.num(dur()));
	}

}
