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

			public static class Weapon {

				public final ForgeConfigSpec.IntValue apoptosisBladeWitherDuration;

				Weapon(ForgeConfigSpec.Builder builder) {
					builder.push("Weapon");

					apoptosisBladeWitherDuration = builder.comment("Apoptosis Blade: Wither effect duration per level in seconds")
							.defineInRange("apoptosisBladeWitherDuration", 2, 0, 100);

					builder.pop();
				}

			}

			public static class Armor {

				Armor(ForgeConfigSpec.Builder builder) {
					builder.push("Armor");

					builder.pop();
				}

			}

			public static class Ranged {

				Ranged(ForgeConfigSpec.Builder builder) {
					builder.push("Bow");

					builder.pop();
				}

			}

			public static class Shield {

				Shield(ForgeConfigSpec.Builder builder) {
					builder.push("Shield");

					builder.pop();
				}

			}

			public static class Trident {

				Trident(ForgeConfigSpec.Builder builder) {
					builder.push("Trident");

					builder.pop();
				}

			}

			public static class Tool {

				Tool(ForgeConfigSpec.Builder builder) {
					builder.push("Tool");

					builder.pop();
				}

			}

			public static class Curse {

				public final ForgeConfigSpec.IntValue curseOfCorrosionInterval;
				public final ForgeConfigSpec.IntValue curseOfCorrosionDurabilityLost;
				public final ForgeConfigSpec.DoubleValue curseOfWeaknessAttackLost;
				public final ForgeConfigSpec.DoubleValue destructionCurseExplosion;
				public final ForgeConfigSpec.DoubleValue destructionCurseOther;
				public final ForgeConfigSpec.DoubleValue curseOfGravityAttackSpeedLost;
				public final ForgeConfigSpec.DoubleValue curseOfIlliteracyExpLost;
				public final ForgeConfigSpec.DoubleValue powerlessCurseMiningSpeedLost;
				public final ForgeConfigSpec.DoubleValue curseOfWitheringHealthLost;

				Curse(ForgeConfigSpec.Builder builder) {
					builder.push("Curse");
					curseOfCorrosionInterval = builder.comment("Curse of Corrosion: time interval in seconds between durability lost")
							.defineInRange("curseOfCorrosionInterval", 5, 1, 100);
					curseOfCorrosionDurabilityLost = builder.comment("Curse of Corrosion: durability lost per level per time interval")
							.defineInRange("curseOfCorrosionDurabilityLost", 1, 1, 100);
					curseOfWeaknessAttackLost = builder.comment("Curse of Weakness: Attack lost per level")
							.defineInRange("curseOfWeaknessAttackLost", 0.15, 0, 0.2);
					destructionCurseExplosion = builder.comment("Destruction Curse: explosion damage amplification per level")
							.defineInRange("destructionCurseExplosion", 0.4, 0, 10);
					destructionCurseOther = builder.comment("Destruction Curse: other damage amplification per level")
							.defineInRange("destructionCurseOther", 0.25, 0, 10);
					curseOfGravityAttackSpeedLost = builder.comment("Curse of Gravity: attack speed lost per level")
							.defineInRange("curseOfGravityAttackSpeedLost", 0.1, 0, 0.2);
					curseOfIlliteracyExpLost = builder.comment("Curse of Illiteracy: exp lost per level")
							.defineInRange("curseOfIlliteracyExpLost", 0.15, 0, 0.33);
					powerlessCurseMiningSpeedLost = builder.comment("Powerless Curse: Mining speed lost per level")
							.defineInRange("powerlessCurseMiningSpeedLost", 0.15, 0, 0.2);
					curseOfWitheringHealthLost = builder.comment("Curse of Withering: max health lost per level per piece")
							.defineInRange("curseOfWitheringHealthLost", 0.05, 0, 0.25);
					builder.pop();
				}

			}

			public final Weapon weapon;
			public final Armor armor;
			public final Ranged ranged;
			public final Shield shield;
			public final Trident trident;
			public final Tool tool;
			public final Curse curse;

			Ench(ForgeConfigSpec.Builder builder) {
				builder.push("Enchantments");
				weapon = new Weapon(builder);
				armor = new Armor(builder);
				ranged = new Ranged(builder);
				shield = new Shield(builder);
				trident = new Trident(builder);
				tool = new Tool(builder);
				curse = new Curse(builder);
				builder.pop();
			}

		}

		public static class Table {

			public final ForgeConfigSpec.DoubleValue extraRollPerAffinity;
			public final ForgeConfigSpec.DoubleValue extraWeightPerAffinity;
			public final ForgeConfigSpec.DoubleValue bookCurseChance;
			public final ForgeConfigSpec.IntValue noCurseAffinity;
			public final ForgeConfigSpec.DoubleValue baseCurseChance;
			public final ForgeConfigSpec.DoubleValue weightCurseReduction;
			public final ForgeConfigSpec.IntValue chaoticPendantWeightBonus;

			Table(ForgeConfigSpec.Builder builder) {
				builder.push("Table");

				extraRollPerAffinity = builder
						.comment("Tool Enchantment Affinity gives extra rounds of enchanting.")
						.comment("This value determines chance per affinity to gain extra rounds")
						.comment("Common tool and armor affinity is 15, and gold is 22-25")
						.defineInRange("extraRollPerAffinity", 0.1, 0, 1);

				extraWeightPerAffinity = builder
						.comment("Tool Enchantment Affinity gives extra weight to enchantments, making rare enchantments more frequent.")
						.comment("This value determines extra weight per affinity. Default weights for enchantments are 1-10")
						.comment("Common tool and armor affinity is 15, and gold is 22-25")
						.defineInRange("extraWeightPerAffinity", 0.1, 0, 10);

				bookCurseChance = builder
						.comment("Chance for book to gain Curse enchantments")
						.defineInRange("bookCurseChance", 0.15, 0, 1);

				noCurseAffinity = builder
						.comment("Tool Enchantment Affinity reduce the chance to have curse enchantments.")
						.comment("This value determines the affinity value where there will be no curse at all, before weight reductions (see below)")
						.comment("Common tool and armor affinity is 15, and gold is 22-25")
						.defineInRange("noCurseAffinity", 30, 0, 100);

				baseCurseChance = builder
						.comment("Chance for gears to gain Curse enchantments, per points of affinity lower than noCurseAffinity")
						.comment("Note that Advanced enchanting has 2x chance, and Legendary has 3x chance to get Curse")
						.defineInRange("baseCurseChance", 0.01, 0, 1);

				weightCurseReduction = builder
						.comment("Extra weights for enchantments will also reduce curse chance")
						.comment("This value determines how much curse chance to decrease per additional weight")
						.defineInRange("weightCurseReduction", 0.02, 0, 1);

				chaoticPendantWeightBonus = builder
						.comment("Chaotic Pendant from Celestial Artifacts gives 3 extra enchantment levels, but it also gives extra weights")
						.comment("This value determines how much weight it will give to enchantments. It also helps reducing curse enchantment chance")
						.defineInRange("chaoticPendantWeightBonus", 10, 0, 100);

				builder.pop();
			}

		}

		public final Ench ench;
		public final Table table;

		private final Map<String, ForgeConfigSpec.BooleanValue> map = new LinkedHashMap<>();

		Common(ForgeConfigSpec.Builder builder) {
			ench = new Ench(builder);
			table = new Table(builder);

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
