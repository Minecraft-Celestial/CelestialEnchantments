package com.xiaoyue.celestial_enchantments.register;

import com.xiaoyue.celestial_enchantments.enchantments.armor.*;
import com.xiaoyue.celestial_enchantments.enchantments.range.*;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ConstraintsShield;
import com.xiaoyue.celestial_enchantments.enchantments.shield.HolyShield;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ReactiveBlock;
import com.xiaoyue.celestial_enchantments.enchantments.shield.ScorchingShield;
import com.xiaoyue.celestial_enchantments.enchantments.tool.AccelerateGrowth;
import com.xiaoyue.celestial_enchantments.enchantments.tool.PhotoDynamic;
import com.xiaoyue.celestial_enchantments.enchantments.tool.PowerlessCurse;
import com.xiaoyue.celestial_enchantments.enchantments.trident.ExplosiveHalberd;
import com.xiaoyue.celestial_enchantments.enchantments.trident.SharpHalberdTip;
import com.xiaoyue.celestial_enchantments.enchantments.weapon.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

public class CEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

    // Generic
    public static final RegistryObject<Enchantment> DEATH_PACT = ENCHANTMENTS.register("death_pact", DeathPact::new);
    public static final RegistryObject<Enchantment> FROST_THORNS = ENCHANTMENTS.register("frost_thorns", FrostThorns::new);
    public static final RegistryObject<Enchantment> HOLY_SHIELD = ENCHANTMENTS.register("holy_shield", HolyShield::new);
    public static final RegistryObject<Enchantment> UPWARD_PICK = ENCHANTMENTS.register("upward_pick", UpwardPick::new);
    public static final RegistryObject<Enchantment> MORNING_STAR = ENCHANTMENTS.register("morning_star", MorningStar::new);
    public static final RegistryObject<Enchantment> FIERCE_SLASH = ENCHANTMENTS.register("fierce_slash", FierceSlash::new);
    public static final RegistryObject<Enchantment> TRAUMA_ABSORPTION = ENCHANTMENTS.register("trauma_absorption", TraumaAbsorption::new);
    public static final RegistryObject<Enchantment> HOLY_PRAYER = ENCHANTMENTS.register("holy_prayer", HolyPrayer::new);
    public static final RegistryObject<Enchantment> BLOOD_THIRST_SLASH = ENCHANTMENTS.register("blood_thirst_slash", BloodThirstSlash::new);
    public static final RegistryObject<Enchantment> DESTROY_RESONANCE = ENCHANTMENTS.register("destroy_resonance", DestroyResonance::new);
    public static final RegistryObject<Enchantment> UNSTABLE_BLADE = ENCHANTMENTS.register("unstable_blade", UnstableBlade::new);
    public static final RegistryObject<Enchantment> KNIGHT_SLASH = ENCHANTMENTS.register("knight_slash", KnightSlash::new);
    public static final RegistryObject<Enchantment> DEATH_BLADE = ENCHANTMENTS.register("death_blade", DeathBlade::new);
    public static final RegistryObject<Enchantment> ECHO_EFFECT = ENCHANTMENTS.register("echo_effect", EchoEffect::new);
    public static final RegistryObject<Enchantment> REVENGE = ENCHANTMENTS.register("revenge", Revenge::new);
    public static final RegistryObject<Enchantment> KNOWLEDGE_SCHOLAR = ENCHANTMENTS.register("knowledge_scholar", KnowledgeScholar::new);
    public static final RegistryObject<Enchantment> VOID_PROTECTION = ENCHANTMENTS.register("void_protection", VoidProtection::new);
    public static final RegistryObject<Enchantment> CLUSTER_AWARENESS = ENCHANTMENTS.register("cluster_awareness", ClusterAwareness::new);
    public static final RegistryObject<Enchantment> PURE_BODY = ENCHANTMENTS.register("pure_body", PureBody::new);
    public static final RegistryObject<Enchantment> APOPTOSIS_BLADE = ENCHANTMENTS.register("apoptosis_blade", ApoptosisBlade::new);
    public static final RegistryObject<Enchantment> CORRUPTION_BODY = ENCHANTMENTS.register("corruption_body", CorruptionBody::new);
    public static final RegistryObject<Enchantment> CELESTIAL_SHELTER = ENCHANTMENTS.register("celestial_shelter", CelestialShelter::new);
    public static final RegistryObject<Enchantment> SHARP_ARROW = ENCHANTMENTS.register("sharp_arrow", SharpArrow::new);
    public static final RegistryObject<Enchantment> HEARTH_SUPPORT = ENCHANTMENTS.register("hearth_support", HearthSupport::new);
    public static final RegistryObject<Enchantment> BORN_IN_SHADOW = ENCHANTMENTS.register("born_in_shadow", BornInShadow::new);
    public static final RegistryObject<Enchantment> SHADOW_TOUCH = ENCHANTMENTS.register("shadow_touch", ShadowTouch::new);
    public static final RegistryObject<Enchantment> PARTING_WISH = ENCHANTMENTS.register("parting_wish", PartingWish::new);
    public static final RegistryObject<Enchantment> DEATH_HATRED = ENCHANTMENTS.register("death_hatred", DeathHatred::new);
    public static final RegistryObject<Enchantment> CORRUPT_SCHOLAR = ENCHANTMENTS.register("corrupt_scholar", CorruptScholar::new);
    public static final RegistryObject<Enchantment> ARROW_STORM = ENCHANTMENTS.register("arrow_storm", ArrowStorm::new);
    public static final RegistryObject<Enchantment> SCORCHING_SHIELD = ENCHANTMENTS.register("scorching_shield", ScorchingShield::new);
    public static final RegistryObject<Enchantment> DESTRUCTION_CRACK = ENCHANTMENTS.register("destruction_crack", DestructionCrack::new);
    public static final RegistryObject<Enchantment> MOON_BLESSING = ENCHANTMENTS.register("moon_blessing", MoonBlessing::new);
    public static final RegistryObject<Enchantment> SUN_BLESSING = ENCHANTMENTS.register("sun_blessing", SunBlessing::new);
    public static final RegistryObject<Enchantment> GIFT_OF_THUNDER_GOD = ENCHANTMENTS.register("gift_of_thunder_god", GiftOfThunderGod::new);
    public static final RegistryObject<Enchantment> REACTIVE_BLOCK = ENCHANTMENTS.register("reactive_block", ReactiveBlock::new);
    public static final RegistryObject<Enchantment> POTION_AFFINITY = ENCHANTMENTS.register("potion_affinity", PotionAffinity::new);
    public static final RegistryObject<Enchantment> FIREPROOF_BOOTS = ENCHANTMENTS.register("fireproof_boots", FireproofBoots::new);
    public static final RegistryObject<Enchantment> DEATH_BLOW = ENCHANTMENTS.register("death_blow", DeathBlow::new);
    public static final RegistryObject<Enchantment> BURST_ARROW = ENCHANTMENTS.register("burst_arrow", BurstArrow::new);
    public static final RegistryObject<Enchantment> QUICK_STEP_PUNCTURE = ENCHANTMENTS.register("quick_step_puncture", QuickStepPuncture::new);
    public static final RegistryObject<Enchantment> ACCELERATE_GROWTH = ENCHANTMENTS.register("accelerate_growth", AccelerateGrowth::new);
    public static final RegistryObject<Enchantment> SOLID_ARMOR = ENCHANTMENTS.register("solid_armor", SolidArmor::new);
    public static final RegistryObject<Enchantment> RAIN_AND_DEW_GRACE = ENCHANTMENTS.register("rain_and_dew_grace", RainAndDewGrace::new);
    public static final RegistryObject<Enchantment> THE_HAND_OF_THIEF = ENCHANTMENTS.register("the_hand_of_thief", TheHandOfThief::new);
    public static final RegistryObject<Enchantment> MAGIC_BLADE = ENCHANTMENTS.register("magic_blade", MagicBlade::new);
    public static final RegistryObject<Enchantment> CONSTRAINTS_SHIELD = ENCHANTMENTS.register("constraints_shield", ConstraintsShield::new);
    public static final RegistryObject<Enchantment> PHOTO_DYNAMIC = ENCHANTMENTS.register("photo_dynamic", PhotoDynamic::new);
    public static final RegistryObject<Enchantment> LIGHT_ARMOR_KILLER = ENCHANTMENTS.register("light_armor_killer", LightArmorKiller::new);
    public static final RegistryObject<Enchantment> QUENCHED_BLADE = ENCHANTMENTS.register("quenched_blade", QuenchedBlade::new);
    public static final RegistryObject<Enchantment> ORIGIN_OF_LIFE = ENCHANTMENTS.register("origin_of_life", OriginOfLife::new);
    public static final RegistryObject<Enchantment> ARROW_OF_TRACTION = ENCHANTMENTS.register("arrow_of_traction", ArrowOfTraction::new);
    public static final RegistryObject<Enchantment> MISFORTUNE_BLADE = ENCHANTMENTS.register("misfortune_blade", MisfortuneBlade::new);
    public static final RegistryObject<Enchantment> FLEET_OF_FOOT = ENCHANTMENTS.register("fleet_of_foot", FleetOfFoot::new);
    public static final RegistryObject<Enchantment> THE_SOURCE_OF_SIN = ENCHANTMENTS.register("the_source_of_sin", TheSourceOfSin::new);
    public static final RegistryObject<Enchantment> DIMENSION_EXPLORER = ENCHANTMENTS.register("dimension_explorer", DimensionExplorer::new);
    public static final RegistryObject<Enchantment> SHARP_HALBERD_TIP = ENCHANTMENTS.register("sharp_halberd_tip", SharpHalberdTip::new);
    public static final RegistryObject<Enchantment> HIDDEN_BLADE = ENCHANTMENTS.register("hidden_blade", HiddenBlade::new);
    public static final RegistryObject<Enchantment> DIVINE_EJACULATION = ENCHANTMENTS.register("divine_ejaculation", DivineEjaculation::new);
    public static final RegistryObject<Enchantment> EYE_IN_SHADOW = ENCHANTMENTS.register("eye_in_shadow", EyeInShadow::new);
    public static final RegistryObject<Enchantment> EXPLOSIVE_HALBERD = ENCHANTMENTS.register("explosive_halberd", ExplosiveHalberd::new);
    public static final RegistryObject<Enchantment> SUPPRESSION_BLADE = ENCHANTMENTS.register("suppression_blade", SuppressionBlade::new);
    public static final RegistryObject<Enchantment> HAVE_NICE_DREAM = ENCHANTMENTS.register("have_nice_dream", HaveNiceDream::new);
    public static final RegistryObject<Enchantment> VOID_CHAIN = ENCHANTMENTS.register("void_chain", VoidChain::new);
    public static final RegistryObject<Enchantment> WORDS_OF_WISDOM = ENCHANTMENTS.register("words_of_wisdom", WordsOfWisdom::new);

    // Cursed
    public static final RegistryObject<Enchantment> DESTRUCTION_CURSE = ENCHANTMENTS.register("destruction_curse", DestructionCurse::new);
    public static final RegistryObject<Enchantment> OVEREATING_CURSE = ENCHANTMENTS.register("overeating_curse", OvereatingCurse::new);
    public static final RegistryObject<Enchantment> CURSE_OF_WEAKNESS = ENCHANTMENTS.register("curse_of_weakness", CurseOfWeakness::new);
    public static final RegistryObject<Enchantment> POWERLESS_CURSE = ENCHANTMENTS.register("powerless_curse", PowerlessCurse::new);

}