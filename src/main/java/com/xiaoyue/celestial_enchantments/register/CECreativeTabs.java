package com.xiaoyue.celestial_enchantments.register;

import com.xiaoyue.celestial_core.utils.ToolTipUtils;
import com.xiaoyue.celestial_enchantments.utils.IEnchUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

public class CECreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> MIN_ENCHANTMENT = CREATIVE_MODE_TABS.register("min_enchantment", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(ToolTipUtils.addLocalTooltip("itemGroup.celestial_enchantments.min_enchantment"))
            .icon(() -> IEnchUtils.addMinEnchBook(CEnchantments.ACCELERATE_GROWTH.get()))
            .displayItems((parameters, output) -> {
                // Generic
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DEATH_PACT.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.FROST_THORNS.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.HOLY_SHIELD.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.UPWARD_PICK.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.MORNING_STAR.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.FIERCE_SLASH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.TRAUMA_ABSORPTION.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.HOLY_PRAYER.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.BLOOD_THIRST_SLASH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DESTROY_RESONANCE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.UNSTABLE_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.KNIGHT_SLASH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DEATH_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.ECHO_EFFECT.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.REVENGE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.KNOWLEDGE_SCHOLAR.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.VOID_PROTECTION.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CLUSTER_AWARENESS.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.PURE_BODY.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.APOPTOSIS_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CORRUPTION_BODY.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CELESTIAL_SHELTER.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SHARP_ARROW.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.HEARTH_SUPPORT.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.BORN_IN_SHADOW.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SHADOW_TOUCH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.PARTING_WISH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DEATH_HATRED.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CORRUPT_SCHOLAR.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.ARROW_STORM.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SCORCHING_SHIELD.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DESTRUCTION_CRACK.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.MOON_BLESSING.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SUN_BLESSING.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.GIFT_OF_THUNDER_GOD.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.REACTIVE_BLOCK.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.POTION_AFFINITY.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.FIREPROOF_BOOTS.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DEATH_BLOW.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.BURST_ARROW.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.QUICK_STEP_PUNCTURE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.ACCELERATE_GROWTH.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SOLID_ARMOR.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.RAIN_AND_DEW_GRACE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.THE_HAND_OF_THIEF.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.MAGIC_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CONSTRAINTS_SHIELD.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.PHOTO_DYNAMIC.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.LIGHT_ARMOR_KILLER.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.QUENCHED_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.ORIGIN_OF_LIFE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.FLEET_OF_FOOT.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.ARROW_OF_TRACTION.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.MISFORTUNE_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.THE_SOURCE_OF_SIN.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DIMENSION_EXPLORER.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SHARP_HALBERD_TIP.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.HIDDEN_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DIVINE_EJACULATION.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.EYE_IN_SHADOW.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.EXPLOSIVE_HALBERD.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.SUPPRESSION_BLADE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.HAVE_NICE_DREAM.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.VOID_CHAIN.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.WORDS_OF_WISDOM.get()));
                // Cursed
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.DESTRUCTION_CURSE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.OVEREATING_CURSE.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.CURSE_OF_WEAKNESS.get()));
                output.accept(IEnchUtils.addMinEnchBook(CEnchantments.POWERLESS_CURSE.get()));
            }).build());

    public static final RegistryObject<CreativeModeTab> MAX_ENCHANTMENT = CREATIVE_MODE_TABS.register("max_enchantment", () -> CreativeModeTab.builder()
            .withTabsBefore(CECreativeTabs.MIN_ENCHANTMENT.getId())
            .title(ToolTipUtils.addLocalTooltip("itemGroup.celestial_enchantments.max_enchantment"))
            .icon(() -> IEnchUtils.addMaxEnchBook(CEnchantments.ACCELERATE_GROWTH.get()))
            .displayItems((parameters, output) -> {
                // Generic
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DEATH_PACT.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.FROST_THORNS.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.HOLY_SHIELD.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.UPWARD_PICK.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.MORNING_STAR.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.FIERCE_SLASH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.TRAUMA_ABSORPTION.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.HOLY_PRAYER.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.BLOOD_THIRST_SLASH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DESTROY_RESONANCE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.UNSTABLE_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.KNIGHT_SLASH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DEATH_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.ECHO_EFFECT.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.REVENGE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.KNOWLEDGE_SCHOLAR.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.VOID_PROTECTION.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CLUSTER_AWARENESS.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.PURE_BODY.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.APOPTOSIS_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CORRUPTION_BODY.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CELESTIAL_SHELTER.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SHARP_ARROW.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.HEARTH_SUPPORT.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.BORN_IN_SHADOW.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SHADOW_TOUCH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.PARTING_WISH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DEATH_HATRED.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CORRUPT_SCHOLAR.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.ARROW_STORM.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SCORCHING_SHIELD.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DESTRUCTION_CRACK.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.MOON_BLESSING.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SUN_BLESSING.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.GIFT_OF_THUNDER_GOD.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.REACTIVE_BLOCK.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.POTION_AFFINITY.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.FIREPROOF_BOOTS.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DEATH_BLOW.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.BURST_ARROW.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.QUICK_STEP_PUNCTURE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.ACCELERATE_GROWTH.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SOLID_ARMOR.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.RAIN_AND_DEW_GRACE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.THE_HAND_OF_THIEF.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.MAGIC_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CONSTRAINTS_SHIELD.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.PHOTO_DYNAMIC.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.LIGHT_ARMOR_KILLER.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.QUENCHED_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.ORIGIN_OF_LIFE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.FLEET_OF_FOOT.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.ARROW_OF_TRACTION.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.MISFORTUNE_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.THE_SOURCE_OF_SIN.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DIMENSION_EXPLORER.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SHARP_HALBERD_TIP.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.HIDDEN_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DIVINE_EJACULATION.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.EYE_IN_SHADOW.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.EXPLOSIVE_HALBERD.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.SUPPRESSION_BLADE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.HAVE_NICE_DREAM.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.VOID_CHAIN.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.WORDS_OF_WISDOM.get()));
                // Cursed
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.DESTRUCTION_CURSE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.OVEREATING_CURSE.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.CURSE_OF_WEAKNESS.get()));
                output.accept(IEnchUtils.addMaxEnchBook(CEnchantments.POWERLESS_CURSE.get()));
            }).build());
}
