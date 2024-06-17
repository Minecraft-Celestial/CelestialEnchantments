package com.xiaoyue.celestial_enchantments.mixin;

import com.xiaoyue.celestial_enchantments.content.enchantments.armor.HaveNiceDream;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

	@Shadow
	public abstract List<ServerPlayer> players();

	@Inject(at = @At("HEAD"), method = "wakeUpAllPlayers")
	public void celestialEnchantments$wakeUpAllPlayers(CallbackInfo ci) {
		for (var e : players()) {
			if (e.isSleeping()) {
				int lv = EnchantmentHelper.getEnchantmentLevel(CEEnchantments.HAVE_NICE_DREAM.get(), e);
				if (lv > 0) HaveNiceDream.onPlayerWake(e, lv);
			}
		}
	}

}
