package com.xiaoyue.celestial_enchantments.mixin;

import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ThrownTrident.class)
public interface MixinTrident {

    @Accessor
    ItemStack getTridentItem();

}
