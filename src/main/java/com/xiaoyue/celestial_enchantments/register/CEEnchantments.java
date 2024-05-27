package com.xiaoyue.celestial_enchantments.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.enchantments.armor.*;
import com.xiaoyue.celestial_enchantments.content.enchantments.range.*;
import com.xiaoyue.celestial_enchantments.content.enchantments.shield.ConstraintsShield;
import com.xiaoyue.celestial_enchantments.content.enchantments.shield.HolyShield;
import com.xiaoyue.celestial_enchantments.content.enchantments.shield.ReactiveBlock;
import com.xiaoyue.celestial_enchantments.content.enchantments.shield.ScorchingShield;
import com.xiaoyue.celestial_enchantments.content.enchantments.tool.AccelerateGrowth;
import com.xiaoyue.celestial_enchantments.content.enchantments.tool.BornInShadow;
import com.xiaoyue.celestial_enchantments.content.enchantments.tool.PhotoDynamic;
import com.xiaoyue.celestial_enchantments.content.enchantments.tool.PowerlessCurse;
import com.xiaoyue.celestial_enchantments.content.enchantments.trident.ExplosiveHalberd;
import com.xiaoyue.celestial_enchantments.content.enchantments.trident.SharpHalberdTip;
import com.xiaoyue.celestial_enchantments.content.enchantments.weapon.*;
import com.xiaoyue.celestial_enchantments.content.generic.CEBaseEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

@SuppressWarnings("unused")
public class CEEnchantments {

	// 16 / 69

	// weapons
	public static final RegistryEntry<Enchantment> WITHERING_BLADE = reg("withering_blade", ApoptosisBlade::new, "Inflict %s"); // effect
	public static final RegistryEntry<Enchantment> UPWARD_PICK = reg("upward_pick", UpwardPick::new, "Inflict %s"); // effect
	public static final RegistryEntry<Enchantment> VAMPIRE_SLASH = reg("vampire_slash", VampireSlash::new, "On attack, heals %s of the damage dealt");// effect

	public static final RegistryEntry<Enchantment> UNSTABLE_BLADE = reg("unstable_blade", UnstableBlade::new, "%s chance to increase damage by %s"); // A30, 22.5%
	public static final RegistryEntry<Enchantment> FIERCE_SLASH = reg("fierce_slash", FierceSlash::new, "Melee damage against the same target is increased by %s"); // A30, 24%
	public static final RegistryEntry<Enchantment> REVENGE = reg("revenge", Revenge::new, "Damage to targets that recently attacked the user is increased by %s"); // A30, 24%
	public static final RegistryEntry<Enchantment> HIDDEN_BLADE = reg("hidden_blade", HiddenBlade::new, "When in %s, increase damage by %s"); // A30, 30%
	public static final RegistryEntry<Enchantment> MISFORTUNE_BLADE = reg("misfortune_blade", MisfortuneBlade::new, "If the target has %s, increase damage by %s"); // A30, 36%
	public static final RegistryEntry<Enchantment> KNIGHT_SLASH = reg("knight_slash", KnightSlash::new, "While riding, increase damage by %s"); // A30, 45%

	public static final RegistryEntry<Enchantment> FATAL_BLOW = reg("fatal_blow", DeathBlow::new, "+%s crit damage"); // A75, 75%
	public static final RegistryEntry<Enchantment> LIGHT_ARMOR_KILLER = reg("light_armor_killer", LightArmorKiller::new, "Increase %s damage to targets with armor below %s"); // A75, 75%
	public static final RegistryEntry<Enchantment> QUICK_STEP_PUNCTURE = reg("quick_step_puncture", QuickStepPuncture::new, "While sprinting, increase damage by %s and knock back the target");// A75, 80%
	public static final RegistryEntry<Enchantment> CLUSTER_AWARENESS = reg("cluster_awareness", ClusterAwareness::new, "For every entity of the same type around the user, increase damage by %s");// A75, 9% per ally

	public static final RegistryEntry<Enchantment> QUENCHED_BLADE = reg("quenched_blade", QuenchedBlade::new, "When attacking a burning target, extinguish the target's flame and increase damage by %s for every remaining seconds of fire, up to %s"); //A300, 144%
	public static final RegistryEntry<Enchantment> WORDS_OF_WISDOM = reg("words_of_wisdom", WordsOfWisdom::new, "Increase damage by %s for every exp level, up to %s");// A300, 180%

	public static final RegistryEntry<Enchantment> DESTRUCTION_CRACK = reg("destruction_crack", DestructionCrack::new, "Target will not be able to have invulnerable frames for %s seconds");// Effect
	public static final RegistryEntry<Enchantment> SUPPRESSION_BLADE = reg("suppression_blade", SuppressionBlade::new, "Target will not be able to heal for %s seconds");// Effect
	public static final RegistryEntry<Enchantment> DEATH_BLADE = reg("death_blade", DeathBlade::new, "Increase damage by %s of the target's maximum health");//A300, up to 4% of target max
	public static final RegistryEntry<Enchantment> MAGIC_BLADE = reg("magic_blade", MagicBlade::new, "When you hurt an target, deal additional magic damage equal to %s of the original damage"); // A300, 100%
	public static final RegistryEntry<Enchantment> VOID_CHAIN = reg("void_chain", VoidChain::new, "When you hurt an target, deal %s of the damage as abyss damage to surrounding monsters");// A300,
	public static final RegistryEntry<Enchantment> SHADOW_TOUCH = reg("shadow_touch", ShadowTouch::new, "When attacking in areas with brightness less than %s, deal an additional %s point of abyss damage to the target"); // A300
	public static final RegistryEntry<Enchantment> THE_HAND_OF_THIEF = reg("the_hand_of_thief", TheHandOfThief::new, "When killing a target, the target will drop all its equipments"); // Effect

	// TODO progress here

	// all armor
	public static final RegistryEntry<Enchantment> VOID_PROTECTION = reg("void_protection", VoidProtection::new, "Reduce %s of void damage received");// A
	public static final RegistryEntry<Enchantment> SOLID_ARMOR = reg("solid_armor", SolidArmor::new, "When the wearer's health is less than half, the damage received is reduced by %s");//A
	public static final RegistryEntry<Enchantment> HEARTH_SUPPORT = reg("hearth_support", HearthSupport::new, "When attacked, burn attacker for %s seconds");//B
	public static final RegistryEntry<Enchantment> DESTROY_RESONANCE = reg("destroy_resonance", DestroyResonance::new, "Deals %s of damage to surrounding targets after being attacked");//B
	public static final RegistryEntry<Enchantment> FROST_THORNS = reg("frost_thorns", FrostThorns::new, "Deals %s damage to the attacker when attacked, and inflicts %s");//B
	// head
	public static final RegistryEntry<Enchantment> EYE_IN_SHADOW = reg("eye_in_shadow", EyeInShadow::new, "In areas with brightness less than %s, gain %s");//C
	public static final RegistryEntry<Enchantment> HAVE_NICE_DREAM = reg("have_nice_dream", HaveNiceDream::new, "After waking up from bed, obtain %s and %s");//C
	public static final RegistryEntry<Enchantment> CORRUPT_SCHOLAR = reg("corrupt_scholar", CorruptScholar::new, "+%s Exp pickup, but there has %s chance to gain harmful effects");//D
	public static final RegistryEntry<Enchantment> KNOWLEDGE_SCHOLAR = reg("knowledge_scholar", KnowledgeScholar::new, "+%s Exp pickup");//D
	public static final RegistryEntry<Enchantment> MOON_BLESSING = reg("moon_blessing", MoonBlessing::new, "At night, gain %s");//C
	public static final RegistryEntry<Enchantment> SUN_BLESSING = reg("sun_blessing", SunBlessing::new, "In daytime, gain %s");//C
	public static final RegistryEntry<Enchantment> RAIN_AND_DEW_GRACE = reg("rain_and_dew_grace", RainAndDewGrace::new, "In water or rain, gain %s");//C
	// chest
	public static final RegistryEntry<Enchantment> GIFT_OF_THUNDER_GOD = reg("gift_of_thunder_god", GiftOfThunderGod::new, "When struck by lightning, immediately recover all lost life, then gain %s, %s, and %s");//C
	public static final RegistryEntry<Enchantment> THE_SOURCE_OF_SIN = reg("the_source_of_sin", TheSourceOfSin::new, "When attacked, has %s chance to make surrounding mobs attack the attacker");//B
	public static final RegistryEntry<Enchantment> TRAUMA_ABSORPTION = reg("trauma_absorption", TraumaAbsorption::new, "On hurt, restore %s of the damage you took");//B
	public static final RegistryEntry<Enchantment> ECHO_EFFECT = reg("echo_effect", EchoEffect::new, "When receiving a fatal attack, dodge the damage and restore %s of maximum health. This effect cools down for %s seconds");
	public static final RegistryEntry<Enchantment> ORIGIN_OF_LIFE = reg("origin_of_life", OriginOfLife::new, "When healing, %s chance to gain %s or %s");
	public static final RegistryEntry<Enchantment> POTION_AFFINITY = reg("potion_affinity", PotionAffinity::new, "The duration of obtained potion effect will increase by %s");
	public static final RegistryEntry<Enchantment> PURE_BODY = reg("pure_body", PureBody::new, "Continuously clearing potion effect on body");
	public static final RegistryEntry<Enchantment> CELESTIAL_SHELTER = reg("celestial_shelter", CelestialShelter::new, "When damaged, a single attack can only deal up to %s of the wearer's maximum health");
	// death
	public static final RegistryEntry<Enchantment> PARTING_WISH = reg("parting_wish", PartingWish::new, "Upon death, surrounding players heal %s points");
	public static final RegistryEntry<Enchantment> DEATH_HATRED = reg("death_hatred", DeathHatred::new, "Deals %s magic damage to surrounding creatures upon death");
	public static final RegistryEntry<Enchantment> DEATH_PACT = reg("death_pact", DeathPact::new, "When nearby players with [%s] die, gives %s chance to gain %s, %s, %s, and %s. Otherwise, you will die together");
	// legs
	public static final RegistryEntry<Enchantment> CORRUPTION_BODY = reg("corruption_body", CorruptionBody::new, "When attacked, inflict attacker with %s");//B
	public static final RegistryEntry<Enchantment> HOLY_PRAYER = reg("holy_prayer", HolyPrayer::new, "When you are attacked while sneaking, gain %s");//B
	// feet
	public static final RegistryEntry<Enchantment> DIMENSION_EXPLORER = reg("dimension_explorer", DimensionExplorer::new, "When you cross dimension, gain %s, %s, and %s");//C
	public static final RegistryEntry<Enchantment> FIREPROOF_BOOTS = reg("fireproof_boots", FireproofBoots::new, "Immune to hot floor damage and reduce fire damage taken by %s");//A
	public static final RegistryEntry<Enchantment> FLEET_OF_FOOT = reg("fleet_of_foot", FleetOfFoot::new, "+%s Movement Speed");//D
	// bow
	public static final RegistryEntry<Enchantment> ARROW_OF_TRACTION = reg("arrow_of_traction", ArrowOfTraction::new, "After hitting target, drag all entities within a radius of %s grid with the target as the center to the target");
	public static final RegistryEntry<Enchantment> ARROW_STORM = reg("arrow_storm", ArrowStorm::new, "Dealing %s of original damage as magical damage to enemies around the target upon hit");
	public static final RegistryEntry<Enchantment> BURST_ARROW = reg("burst_arrow", BurstArrow::new, "%s chance explode when hitting target, but does not break the blocks");
	public static final RegistryEntry<Enchantment> MORNING_STAR = reg("morning_star", MorningStar::new, "After arrow hits a target, %s chance to strike the target with lightning");
	public static final RegistryEntry<Enchantment> SHARP_ARROW = reg("sharp_arrow", SharpArrow::new, "Increase %s Arrow Damage");
	public static final RegistryEntry<Enchantment> DIVINE_PROJECTION = reg("divine_projection", DivineProjection::new, "The further away from the attacking target, the higher the damage");

	// shield
	public static final RegistryEntry<Enchantment> CONSTRAINTS_SHIELD = reg("constraints_shield", ConstraintsShield::new, "After blocking %s damage, next blocking will reflect %s damage as magic damage");
	public static final RegistryEntry<Enchantment> HOLY_SHIELD = reg("holy_shield", HolyShield::new, "Gain %s after shielding attacks");
	public static final RegistryEntry<Enchantment> REACTIVE_BLOCK = reg("reactive_block", ReactiveBlock::new, "After blocking an attack, knock back attack with strength of %s");
	public static final RegistryEntry<Enchantment> SCORCHING_SHIELD = reg("scorching_shield", ScorchingShield::new, "Using a shield to block an attack will cause the attacker to burn for %s seconds");

	// tool
	public static final RegistryEntry<Enchantment> PHOTO_DYNAMIC = reg("photo_dynamic", PhotoDynamic::new, "In areas with brightness above %s, increase %s mining speed");
	public static final RegistryEntry<Enchantment> ACCELERATE_GROWTH = reg("accelerate_growth", AccelerateGrowth::new, "Right click to consume durability and fertilize crops");

	// trident
	public static final RegistryEntry<Enchantment> SHARP_HALBERD_TIP = reg("sharp_halberd_tip", SharpHalberdTip::new, "Increase %s melee and throwing damage");
	public static final RegistryEntry<Enchantment> EXPLOSIVE_HALBERD = reg("explosive_halberd", ExplosiveHalberd::new, "The thrown trident has a %s chance to explode");

	// generic
	public static final RegistryEntry<Enchantment> BORN_IN_SHADOW = reg("born_in_shadow", BornInShadow::new, "Durability will slowly recover in areas with brightness less than %s");
	// TODO photosynthesis

	// curse
	public static final RegistryEntry<Enchantment> DESTRUCTION_CURSE = reg("destruction_curse", DestructionCurse::new, "Increase explosion damage received by %s, and increase other incoming damage by %s");
	public static final RegistryEntry<Enchantment> OVEREATING_CURSE = reg("overeating_curse", OvereatingCurse::new, "Gain %s");
	public static final RegistryEntry<Enchantment> CURSE_OF_WEAKNESS = reg("curse_of_weakness", CurseOfWeakness::new, "-%s of attack damage");
	public static final RegistryEntry<Enchantment> POWERLESS_CURSE = reg("powerless_curse", PowerlessCurse::new, "-%s mining speed");
	//TODO dragging curse


	public static RegistryEntry<Enchantment> reg(String id, NonNullSupplier<? extends Enchantment> sup, String desc) {
		return CelestialEnchantments.REGISTRATE.enchantment(id, EnchantmentCategory.BREAKABLE,
				(r, c, s) -> (Enchantment) sup.get(), desc).register();
	}

	public static void register() {
		CEBaseEnchantment.injectTab(CelestialEnchantments.REGISTRATE);
	}

}