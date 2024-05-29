package com.xiaoyue.celestial_enchantments.content.client;

import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import dev.xkmc.l2library.capability.conditionals.ConditionalData;
import dev.xkmc.l2library.capability.conditionals.ConditionalToken;
import dev.xkmc.l2library.capability.conditionals.TokenKey;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import javax.annotation.Nullable;

public class ClientEffectHandlers {

	public static void echoEffectActivation(Player player) {
		Minecraft.getInstance().particleEngine.createTrackingEmitter(player, ParticleTypes.TOTEM_OF_UNDYING, 30);
		player.level().playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.TOTEM_USE, player.getSoundSource(), 1.0F, 1.0F, false);
		Minecraft.getInstance().gameRenderer.displayItemActivation(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(CEEnchantments.ECHO_EFFECT.get(), 1)));
	}

	@Nullable
	public static <T extends ConditionalToken> T getPlayerDataClientSide(TokenKey<T> key) {
		var player = Minecraft.getInstance().player;
		if (player == null) return null;
		var data = ConditionalData.HOLDER.get(player);
		return data.getData(key);
	}

}
