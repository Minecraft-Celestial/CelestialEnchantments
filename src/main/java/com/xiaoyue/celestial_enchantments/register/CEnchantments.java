package com.xiaoyue.celestial_enchantments.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.enchantments.armor.*;
import com.xiaoyue.celestial_enchantments.enchantments.range.*;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ConstraintsShield;
import com.xiaoyue.celestial_enchantments.enchantments.shield.HolyShield;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ReactiveBlock;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ScorchingShield;
import com.xiaoyue.celestial_enchantments.enchantments.tool.AccelerateGrowth;
import com.xiaoyue.celestial_enchantments.enchantments.tool.BornInShadow;
import com.xiaoyue.celestial_enchantments.enchantments.tool.PhotoDynamic;
import com.xiaoyue.celestial_enchantments.enchantments.tool.PowerlessCurse;
import com.xiaoyue.celestial_enchantments.enchantments.trident.ExplosiveHalberd;
import com.xiaoyue.celestial_enchantments.enchantments.trident.SharpHalberdTip;
import com.xiaoyue.celestial_enchantments.enchantments.weapon.*;
import com.xiaoyue.celestial_enchantments.generic.XCEnchBase;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CEnchantments {

	// Generic
	public static final RegistryEntry<Enchantment> DEATH_PACT = reg("death_pact", DeathPact::new, "When nearby players with Death Pact die, there is a 15% chance of [Enchantment Level] to gain strength, increase speed, restore health, and absorb damage. Otherwise, you will die together");
	public static final RegistryEntry<Enchantment> FROST_THORNS = reg("frost_thorns", FrostThorns::new, "Deals [Enchantment Level] damage to the attacker when attacked, and grants the target a slow effect");
	public static final RegistryEntry<Enchantment> HOLY_SHIELD = reg("holy_shield", HolyShield::new, "Obtain a short-term damage absorption effect after using a shield to block attacks");
	public static final RegistryEntry<Enchantment> UPWARD_PICK = reg("upward_pick", UpwardPick::new, "Give the target a brief floating effect");
	public static final RegistryEntry<Enchantment> MORNING_STAR = reg("morning_star", MorningStar::new, "After the arrow hits the target, it will summon lightning with a 50% chance of [enchantment level] times");
	public static final RegistryEntry<Enchantment> FIERCE_SLASH = reg("fierce_slash", FierceSlash::new, "If you have attacked a creature in a short period of time, increase [Enchantment Level] * 10% of attack damage when attacking again");
	public static final RegistryEntry<Enchantment> TRAUMA_ABSORPTION = reg("trauma_absorption", TraumaAbsorption::new, "When hit, restore lost HP * [Enchantment Level] * 9% HP");
	public static final RegistryEntry<Enchantment> HOLY_PRAYER = reg("holy_prayer", HolyPrayer::new, "Attacked while stealth gains health recovery effect");
	public static final RegistryEntry<Enchantment> BLOOD_THIRST_SLASH = reg("blood_thirst_slash", BloodThirstSlash::new, "Restore original damage * [enchantment level] * 10% health after attack");
	public static final RegistryEntry<Enchantment> DESTROY_RESONANCE = reg("destroy_resonance", DestroyResonance::new, "Deals one [Enchantment Level] * 2 attack damage to surrounding targets after being attacked");
	public static final RegistryEntry<Enchantment> UNSTABLE_BLADE = reg("unstable_blade", UnstableBlade::new, "When attacking, there is a [Enchantment Level] * 10% chance to increase the damage of this attack by 25%");
	public static final RegistryEntry<Enchantment> KNIGHT_SLASH = reg("knight_slash", KnightSlash::new, "Attack damage increased by [Enchantment Level] * 15% while riding");
	public static final RegistryEntry<Enchantment> DEATH_BLADE = reg("death_blade", DeathBlade::new, "Increase [Enchantment Level] * 5% of the target's maximum health attack damage during attack, with a maximum damage limit of [Enchantment Level] * 75");
	public static final RegistryEntry<Enchantment> ECHO_EFFECT = reg("echo_effect", EchoEffect::new, "When receiving a fatal attack, dodge the damage and restore [Enchantment Level] * 5% of maximum health. This effect cools down for 600 seconds");
	public static final RegistryEntry<Enchantment> REVENGE = reg("revenge", Revenge::new, "Attacking a target that has recently attacked oneself increases [Enchantment Level] by 10% of attack damage");
	public static final RegistryEntry<Enchantment> KNOWLEDGE_SCHOLAR = reg("knowledge_scholar", KnowledgeScholar::new, "Increase [Enchantment Level] * 10% experience acquisition when picking up experience");
	public static final RegistryEntry<Enchantment> VOID_PROTECTION = reg("void_protection", VoidProtection::new, "Reduce [Enchantment Level] * 8% of Void damage received");
	public static final RegistryEntry<Enchantment> CLUSTER_AWARENESS = reg("cluster_awareness", ClusterAwareness::new, "For every creature of the same type around the user, increase [Enchantment Level] * 12% of attack damage");
	public static final RegistryEntry<Enchantment> PURE_BODY = reg("pure_body", PureBody::new, "Continuously clearing the potion effect on the body");
	public static final RegistryEntry<Enchantment> APOPTOSIS_BLADE = reg("apoptosis_blade", ApoptosisBlade::new, "After attacking, give the target a [Enchantment Level] * 2 second fade effect");
	public static final RegistryEntry<Enchantment> CORRUPTION_BODY = reg("corruption_body", CorruptionBody::new, "When attacked, reduces the attacker's enchantment level by 3 points of armor for a period of time");
	public static final RegistryEntry<Enchantment> CELESTIAL_SHELTER = reg("celestial_shelter", CelestialShelter::new, "When damaged, a single attack can only receive up to 25% of the wearer's maximum health");
	public static final RegistryEntry<Enchantment> SHARP_ARROW = reg("sharp_arrow", SharpArrow::new, "Increase [Enchantment Level] * 20% Arrow Damage");
	public static final RegistryEntry<Enchantment> HEARTH_SUPPORT = reg("hearth_support", HearthSupport::new, "When attacked, causes the attacker to fall into [Enchantment Level] * 2 seconds of combustion");
	public static final RegistryEntry<Enchantment> BORN_IN_SHADOW = reg("born_in_shadow", BornInShadow::new, "Durability will slowly recover in areas with brightness less than 5");
	public static final RegistryEntry<Enchantment> SHADOW_TOUCH = reg("shadow_touch", ShadowTouch::new, "When attacking in areas with brightness less than 5, deal an additional [enchantment level] point of void damage to the target");
	public static final RegistryEntry<Enchantment> PARTING_WISH = reg("parting_wish", PartingWish::new, "Restore 8 health points to surrounding players at their enchantment level upon death");
	public static final RegistryEntry<Enchantment> DEATH_HATRED = reg("death_hatred", DeathHatred::new, "Deals [Enchantment Level] * 15 magic damage to surrounding creatures upon death");
	public static final RegistryEntry<Enchantment> CORRUPT_SCHOLAR = reg("corrupt_scholar", CorruptScholar::new, "When picking up experience, increase [Enchantment Level] * 80% experience acquisition, but there is a 25% chance of [Enchantment Level] * obtaining negative effects");
	public static final RegistryEntry<Enchantment> ARROW_STORM = reg("arrow_storm", ArrowStorm::new, "Arrow damage reduced by [Enchantment Level] * 5%, dealing original damage [Enchantment Level] * 10% projectile damage to enemies around the target upon hit");
	public static final RegistryEntry<Enchantment> SCORCHING_SHIELD = reg("scorching_shield", ScorchingShield::new, "Using a shield to block an attack will cause the attacker to fall into [Enchantment Level] and burn for seconds");
	public static final RegistryEntry<Enchantment> DESTRUCTION_CRACK = reg("destruction_crack", DestructionCrack::new, "Add a crack mark to the target after the attack. If you have a crack mark, you cannot gain invincible time after being attacked");
	public static final RegistryEntry<Enchantment> MOON_BLESSING = reg("moon_blessing", MoonBlessing::new, "Continuously gain [Enchantment Level] level health recovery effect while at night");
	public static final RegistryEntry<Enchantment> SUN_BLESSING = reg("sun_blessing", SunBlessing::new, "Continuously gains [Enchantment Level] strength effects while in the daytime");
	public static final RegistryEntry<Enchantment> GIFT_OF_THUNDER_GOD = reg("gift_of_thunder_god", GiftOfThunderGod::new, "When attacked by lightning, immediately recover 100% of lost life and obtain a brief [Enchantment Level] level speed increase and resistance enhancement effect");
	public static final RegistryEntry<Enchantment> REACTIVE_BLOCK = reg("reactive_block", ReactiveBlock::new, "After using a shield to block an attack, use [Enchantment Level] * 0.5 to repel the attacker");
	public static final RegistryEntry<Enchantment> POTION_AFFINITY = reg("potion_affinity", PotionAffinity::new, "The duration of the obtained potion effect has been increased by [Enchantment Level] * 15%");
	public static final RegistryEntry<Enchantment> FIREPROOF_BOOTS = reg("fireproof_boots", FireproofBoots::new, "Immune to Magma Block damage and reduce flame damage taken by 15%");
	public static final RegistryEntry<Enchantment> DEATH_BLOW = reg("death_blow", DeathBlow::new, "Increase [Enchantment Level] * 25% critical damage on critical strikes");
	public static final RegistryEntry<Enchantment> BURST_ARROW = reg("burst_arrow", BurstArrow::new, "After hitting the target, there is a [Enchantment Level] * 20% chance of an explosion, which does not damage the blocks");
	public static final RegistryEntry<Enchantment> QUICK_STEP_PUNCTURE = reg("quick_step_puncture", QuickStepPuncture::new, "Increase [Enchantment Level] * 16% of attack damage when attacking the target while running, and repel the target with higher repulsion force");
	public static final RegistryEntry<Enchantment> ACCELERATE_GROWTH = reg("accelerate_growth", AccelerateGrowth::new, "Right click on the crop to consume some durability to ripen the crop");
	public static final RegistryEntry<Enchantment> SOLID_ARMOR = reg("solid_armor", SolidArmor::new, "When the wearer's health is less than half, the damage received is reduced by [Enchantment Level] * 12%");
	public static final RegistryEntry<Enchantment> RAIN_AND_DEW_GRACE = reg("rain_and_dew_grace", RainAndDewGrace::new, "Continuously restores the wearer's life during rainy weather");
	public static final RegistryEntry<Enchantment> THE_HAND_OF_THIEF = reg("the_hand_of_thief", TheHandOfThief::new, "When killing a target, the probability of the target dropping the equipment they are wearing increases to 100%");
	public static final RegistryEntry<Enchantment> MAGIC_BLADE = reg("magic_blade", MagicBlade::new, "Your attack will receive additional magic damage equal to the original damage");
	public static final RegistryEntry<Enchantment> CONSTRAINTS_SHIELD = reg("constraints_shield", ConstraintsShield::new, "After 4 attacks per block, deal 50% of the original damage [enchantment level] * magic damage to the attacker on the next block");
	public static final RegistryEntry<Enchantment> PHOTO_DYNAMIC = reg("photo_dynamic", PhotoDynamic::new, "Increase [Enchantment Level] * 12% mining speed in areas with brightness above 10");
	public static final RegistryEntry<Enchantment> LIGHT_ARMOR_KILLER = reg("light_armor_killer", LightArmorKiller::new, "Increase [Enchantment Level] * 25% attack damage when attacking targets with armor values below 8");
	public static final RegistryEntry<Enchantment> QUENCHED_BLADE = reg("quenched_blade", QuenchedBlade::new, "When attacking a burning target, extinguish the target's flame and increase [Enchantment Level] * 10% attack damage every 2 seconds based on the remaining burning time before extinguishment");
	public static final RegistryEntry<Enchantment> ORIGIN_OF_LIFE = reg("origin_of_life", OriginOfLife::new, "There is a probability of obtaining resistance improvement or speed improvement effects when receiving treatment");
	public static final RegistryEntry<Enchantment> ARROW_OF_TRACTION = reg("arrow_of_traction", ArrowOfTraction::new, "After hitting the target, drag all entities within a radius of [enchantment level]+1 grid with the target as the center to the target");
	public static final RegistryEntry<Enchantment> MISFORTUNE_BLADE = reg("misfortune_blade", MisfortuneBlade::new, "Increase [Enchantment Level] * 10% Movement Speed");
	public static final RegistryEntry<Enchantment> FLEET_OF_FOOT = reg("fleet_of_foot", FleetOfFoot::new, "After attacking, give the target 4 seconds to be poisoned. When the target is poisoned, the attack damage increases by [Enchantment Level] * 25%");
	public static final RegistryEntry<Enchantment> THE_SOURCE_OF_SIN = reg("the_source_of_sin", TheSourceOfSin::new, "When attacked, there is a 20% chance of [Enchantment Level] * making the attacker the target of surrounding creatures");
	public static final RegistryEntry<Enchantment> DIMENSION_EXPLORER = reg("dimension_explorer", DimensionExplorer::new, "Gain 30 seconds of [Enchantment Level] level luck, strength, and urgency effects after crossing dimension each time");
	public static final RegistryEntry<Enchantment> SHARP_HALBERD_TIP = reg("sharp_halberd_tip", SharpHalberdTip::new, "Increase [Enchantment Level] * 20% melee and throw damage");
	public static final RegistryEntry<Enchantment> HIDDEN_BLADE = reg("hidden_blade", HiddenBlade::new, "When equipped with stealth effect, the attack target increases [Enchantment Level] * 26% of attack damage");
	public static final RegistryEntry<Enchantment> DIVINE_EJACULATION = reg("divine_ejaculation", DivineEjaculation::new, "The farther away from the attacking target, the higher the damage");
	public static final RegistryEntry<Enchantment> EYE_IN_SHADOW = reg("eye_in_shadow", EyeInShadow::new, "Continuously achieve night vision effects in areas with brightness less than 5");
	public static final RegistryEntry<Enchantment> EXPLOSIVE_HALBERD = reg("explosive_halberd", ExplosiveHalberd::new, "The thrown trident has a [Enchantment Level] * 20% chance of exploding");
	public static final RegistryEntry<Enchantment> SUPPRESSION_BLADE = reg("suppression_blade", SuppressionBlade::new, "After the attack, the target will no longer be able to regain life");
	public static final RegistryEntry<Enchantment> HAVE_NICE_DREAM = reg("have_nice_dream", HaveNiceDream::new, "After waking up from bed, obtain [enchantment level] level health recovery and jump enhancement effects");
	public static final RegistryEntry<Enchantment> VOID_CHAIN = reg("void_chain", VoidChain::new, "Reduce attack damage by 90%, deal original damage * [enchantment level] * 50% damage to surrounding targets after attack");
	public static final RegistryEntry<Enchantment> WORDS_OF_WISDOM = reg("words_of_wisdom", WordsOfWisdom::new, "Increase attack damage by 5% for every level 5 experience level, with a maximum of [enchantment level] * 20%");
	public static final RegistryEntry<Enchantment> DESTRUCTION_CURSE = reg("destruction_curse", DestructionCurse::new, "Increase explosion damage received by 40%, and increase other damage by 25%");
	public static final RegistryEntry<Enchantment> OVEREATING_CURSE = reg("overeating_curse", OvereatingCurse::new, "Continuously obtain [Enchantment Level] level hunger effect");
	public static final RegistryEntry<Enchantment> CURSE_OF_WEAKNESS = reg("curse_of_weakness", CurseOfWeakness::new, "Reduce [Enchantment Level] * 15% of attack damage");
	public static final RegistryEntry<Enchantment> POWERLESS_CURSE = reg("powerless_curse", PowerlessCurse::new, "Reduce [Enchantment Level] * 15% of mining speed");

	public static RegistryEntry<Enchantment> reg(String id, NonNullSupplier<? extends Enchantment> sup, String desc) {
		return CelestialEnchantments.REGISTRATE.enchantment(id, EnchantmentCategory.BREAKABLE,
				(r, c, s) -> (Enchantment) sup.get(), desc).register();
	}

	public static void register() {
		XCEnchBase.injectTab(CelestialEnchantments.REGISTRATE);
	}

}