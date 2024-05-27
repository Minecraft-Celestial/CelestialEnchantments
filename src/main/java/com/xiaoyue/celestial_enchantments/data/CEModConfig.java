package com.xiaoyue.celestial_enchantments.data;

import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

public class CEModConfig {

	public static class Client {

		Client(ForgeConfigSpec.Builder builder) {

		}

	}

	public static class Common {

		public static class Ench {

			Ench(ForgeConfigSpec.Builder builder) {
				builder.push("Enchantments");

				builder.pop();
			}

		}

		public static class Misc {

			Misc(ForgeConfigSpec.Builder builder) {
				builder.push("Table");
					
				builder.pop();
			}

		}

		public final Ench ench;
		public final Misc misc;

		private final Map<String, ForgeConfigSpec.BooleanValue> map = new LinkedHashMap<>();

		Common(ForgeConfigSpec.Builder builder) {
			ench = new Ench(builder);
			misc = new Misc(builder);

			builder.push("Toggles");
			for (var e : CEEnchantments.ALL_ENCH) {
				map.put(e, builder.define(e, true));
			}
			builder.pop();
		}

		public boolean enabled(CEBaseEnchantment ce) {
			var config = map.get(ce.getID().getPath());
			if (config == null) return true;
			return config.get();
		}

	}

	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final Client CLIENT;

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	public static String COMMON_PATH;

	static {
		final Pair<Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = client.getRight();
		CLIENT = client.getLeft();

		final Pair<Common, ForgeConfigSpec> common = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = common.getRight();
		COMMON = common.getLeft();
	}

	/**
	 * Registers any relevant listeners for config
	 */
	public static void init() {
		register(ModConfig.Type.CLIENT, CLIENT_SPEC);
		COMMON_PATH = register(ModConfig.Type.COMMON, COMMON_SPEC);
	}

	private static String register(ModConfig.Type type, IConfigSpec<?> spec) {
		var mod = ModLoadingContext.get().getActiveContainer();
		String path = "celestial_configs/" + mod.getModId() + "-" + type.extension() + ".toml";
		ModLoadingContext.get().registerConfig(type, spec, path);
		return path;
	}

}
