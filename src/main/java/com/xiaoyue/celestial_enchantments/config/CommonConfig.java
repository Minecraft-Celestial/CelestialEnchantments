package com.xiaoyue.celestial_enchantments.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    public static ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec.IntValue DEATH_BLADE_MAX_ADD_DAMAGE = builder
            .comment("This value determines the maximum damage increase")
            .defineInRange("death_blade_max_add_damage", 75, 1, Integer.MAX_VALUE);

    public static ForgeConfigSpec spec = builder.build();
}
