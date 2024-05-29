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

				public final ForgeConfigSpec.DoubleValue abyssalContactReduction;
				public final ForgeConfigSpec.DoubleValue abyssalContactAmplification;
				public final ForgeConfigSpec.DoubleValue celestialShelterDamageCap;
				public final ForgeConfigSpec.IntValue corruptionBodyDuration;
				public final ForgeConfigSpec.IntValue corruptScholarDuration;
				public final ForgeConfigSpec.DoubleValue corruptScholarChance;
				public final ForgeConfigSpec.DoubleValue corruptScholarExpBonus;
				public final ForgeConfigSpec.IntValue dimensionExplorerDuration;
				public final ForgeConfigSpec.DoubleValue echoEffectHeal;
				public final ForgeConfigSpec.IntValue echoEffectCooldown;
				public final ForgeConfigSpec.IntValue eyesInShadowsMaxLight;
				public final ForgeConfigSpec.DoubleValue fireproofBootsReduction;
				public final ForgeConfigSpec.IntValue flameStrikeDuration;
				public final ForgeConfigSpec.DoubleValue fleetOfFootSpeed;
				public final ForgeConfigSpec.IntValue frostThornDamage;
				public final ForgeConfigSpec.IntValue frostThornDuration;
				public final ForgeConfigSpec.DoubleValue giftOfThunderGodHeal;
				public final ForgeConfigSpec.IntValue giftOfThunderGodDuration;
				public final ForgeConfigSpec.IntValue haveANiceDreamDuration;
				public final ForgeConfigSpec.DoubleValue knowledgeScholarExpBonus;
				public final ForgeConfigSpec.DoubleValue lifeShieldPercentage;
				public final ForgeConfigSpec.IntValue originOfLifeDuration;
				public final ForgeConfigSpec.DoubleValue originOfLifeChance;
				public final ForgeConfigSpec.DoubleValue potionAffinityExtension;
				public final ForgeConfigSpec.DoubleValue solidArmorReduction;
				public final ForgeConfigSpec.DoubleValue traumaAbsorptionHeal;
				public final ForgeConfigSpec.DoubleValue voidProtectionReduction;

				public final ForgeConfigSpec.IntValue deathHatredDamage;
				public final ForgeConfigSpec.IntValue deathHatredRadius;
				public final ForgeConfigSpec.IntValue deathPackDuration;
				public final ForgeConfigSpec.DoubleValue deathPackChance;
				public final ForgeConfigSpec.IntValue deathPackRadius;
				public final ForgeConfigSpec.DoubleValue partingWishHeal;
				public final ForgeConfigSpec.IntValue partingWishRadius;
				public final ForgeConfigSpec.DoubleValue theSourceOfSinChance;
				public final ForgeConfigSpec.IntValue theSourceOfSinRadius;
				public final ForgeConfigSpec.DoubleValue destroyResonanceDamage;
				public final ForgeConfigSpec.IntValue destroyResonanceRadius;

				//TODO death hatred, death pack, destroy resonance,parting wish,the source of sin


				Armor(ForgeConfigSpec.Builder builder) {
					builder.push("Armor");

					abyssalContactReduction = builder.comment("Abyssal Contact: Abyss damage reduction")
							.defineInRange("abyssalContactReduction", 0.06, 0, 1);
					abyssalContactAmplification = builder.comment("Abyssal Contact: Other damage amplification")
							.defineInRange("abyssalContactAmplification", 0.12, 0, 10);

					celestialShelterDamageCap = builder.comment("Celestial Shelter: Max damage to take as percentage of max health")
							.defineInRange("celestialShelterDamageCap", 0.25, 0, 1);

					corruptionBodyDuration = builder.comment("Corruption Body: Duration of corruption in seconds to inflict to attacker")
							.defineInRange("corruptionBodyDuration", 30, 0, 600);

					corruptScholarDuration = builder.comment("Corrupt Scholar: Duration of negative effects to get when pick up exp orbs")
							.defineInRange("corruptScholarDuration", 5, 0, 600);
					corruptScholarChance = builder.comment("Corrupt Scholar: Chance per level to get negative effects when pick up exp orbs")
							.defineInRange("corruptScholarChance", 0.25, 0, 1);
					corruptScholarExpBonus = builder.comment("Corrupt Scholar: Exp pickup bonus per level")
							.defineInRange("corruptScholarExpBonus", 0.8, 0, 1);

					dimensionExplorerDuration = builder.comment("Dimension Explorer: Duration of effects in seconds to gain")
							.defineInRange("dimensionExplorerDuration", 60, 0, 600);

					echoEffectHeal = builder.comment("Echo Effect: Percentage of max health to heal")
							.defineInRange("echoEffectHeal", 0.05, 0, 1);
					echoEffectCooldown = builder.comment("Echo Effect: Cool down of totem effect")
							.defineInRange("echoEffectCooldown", 600, 0, 60000);

					eyesInShadowsMaxLight = builder.comment("Eyes in Shadows: maximum light level to give Night Vision")
							.defineInRange("eyesInShadowsMaxLight", 5, 0, 15);

					fireproofBootsReduction = builder.comment("Fireproof Boots: fire damage reduction")
							.defineInRange("fireproofBootsReduction", 0.85, 0, 1);

					flameStrikeDuration = builder.comment("Flame Strike: duration of fire per level to inflict")
							.defineInRange("flameStrikeDuration", 2, 0, 600);

					fleetOfFootSpeed = builder.comment("Fleet of Foot: speed bonus")
							.defineInRange("fleetOfFootSpeed", 0.1, 0, 1);

					frostThornDamage = builder.comment("Frost Thorn: thorn damage")
							.defineInRange("frostThornDamage", 1, 0, 100);
					frostThornDuration = builder.comment("Frost Thorn: duration per level to slow down")
							.defineInRange("frostThornDuration", 2, 0, 600);

					giftOfThunderGodHeal = builder.comment("Gift of Thunder God: percentage of lost health to heal per level")
							.defineInRange("giftOfThunderGodHeal", 0.1, 0, 1);
					giftOfThunderGodDuration = builder.comment("Gift of Thunder God: duration of effects to gain")
							.defineInRange("giftOfThunderGodDuration", 10, 0, 600);

					haveANiceDreamDuration = builder.comment("Have a Nice Dream: duration of effects to gain")
							.defineInRange("haveANiceDreamDuration", 60, 0, 600);

					knowledgeScholarExpBonus = builder.comment("Knowledge Scholar: Exp pickup bonus")
							.defineInRange("knowledgeScholarExpBonus", 0.1, 0, 1);

					lifeShieldPercentage = builder.comment("Life Shield: Absorption healing percentage")
							.defineInRange("lifeShieldPercentage", 0.2, 0, 1);

					originOfLifeDuration = builder.comment("Origin of Life: Duration of positive effects to get when healing")
							.defineInRange("originOfLifeDuration", 5, 0, 600);
					originOfLifeChance = builder.comment("Origin of Life: Chance per level to get positive effects when healing")
							.defineInRange("originOfLifeChance", 0.1, 0, 1);

					potionAffinityExtension = builder.comment("Potion Affinity: Effect duration extionsion per level")
							.defineInRange("potionAffinityExtension", 0.15, 0, 1);

					solidArmorReduction = builder.comment("Solid Armor: Damage reduction per level")
							.defineInRange("solidArmorReduction", 0.03, 0, 1);

					traumaAbsorptionHeal = builder.comment("Trauma Absorption: Healing per level")
							.defineInRange("traumaAbsorptionHeal", 0.04, 0, 1);

					voidProtectionReduction = builder.comment("Void Protection: Void damage reduction per level")
							.defineInRange("voidProtectionReduction", 0.04, 0, 1);

					/*
				public final ForgeConfigSpec.DoubleValue theSourceOfSinChance;
				public final ForgeConfigSpec.IntValue theSourceOfSinRadius;
				public final ForgeConfigSpec.DoubleValue destroyResonanceDamage;
				public final ForgeConfigSpec.IntValue destroyResonanceRadius;
					*
					* */

					deathHatredDamage = builder.comment("Death Hatred: Damage for surrounding mobs")
							.defineInRange("deathHatredDamage", 15, 0, 100);
					deathHatredRadius = builder.comment("Death Hatred: Radius for damaging surrounding mobs")
							.defineInRange("deathHatredRadius", 6, 0, 24);

					deathPackDuration = builder.comment("Death Pack: Duration in seconds for positive effects")
							.defineInRange("deathPackDuration", 10, 0, 100);
					deathPackChance = builder.comment("Death Pack: Chance of not dying together")
							.defineInRange("deathPackChance", 0.2, 0, 1);
					deathPackRadius = builder.comment("Death Pack: Radius for detection")
							.defineInRange("deathPackRadius", 12, 0, 24);

					partingWishHeal = builder.comment("Parting Wish: Percentage of max health to heal")
							.defineInRange("partingWishHeal", 0.3, 0, 1);
					partingWishRadius = builder.comment("Parting Wish: Radius for detection")
							.defineInRange("partingWishRadius", 12, 0, 24);

					theSourceOfSinChance = builder.comment("The Source of Sin: Chance of redirecting anger")
							.defineInRange("theSourceOfSinChance", 0.1, 0, 1);
					theSourceOfSinRadius = builder.comment("The Source of Sin: Radius for detection")
							.defineInRange("theSourceOfSinRadius", 3, 0, 24);

					destroyResonanceDamage = builder.comment("Destroy Resonance: Damage as percentage of incoming damage to deal")
							.defineInRange("destroyResonanceDamage", 0.1, 0, 1);
					destroyResonanceRadius = builder.comment("Destroy Resonance: Radius for damage")
							.defineInRange("destroyResonanceRadius", 6, 0, 24);

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
