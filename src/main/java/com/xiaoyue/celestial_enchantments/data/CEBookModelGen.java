package com.xiaoyue.celestial_enchantments.data;

import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.register.CEEnchantments;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;

import static com.xiaoyue.celestial_enchantments.CelestialEnchantments.MODID;

public class CEBookModelGen extends ItemModelProvider {
    public CEBookModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (String id : CEEnchantments.ALL_ENCH.keySet()) {
            getBuilder(id).parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", CelestialEnchantments.loc("item/book/" + id));
        }
        getBuilder("compound_book").parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", CelestialEnchantments.loc("item/book/compound_book"));
        ItemModelBuilder builder = basicItem(Items.ENCHANTED_BOOK);
        for (Map.Entry<String, Integer> entry : CEEnchantments.ALL_ENCH.entrySet()) {
            builder.override().predicate(CelestialEnchantments.loc("book"), entry.getValue())
                    .model(new ModelFile.UncheckedModelFile(CelestialEnchantments.loc("item/" + entry.getKey())))
                    .end();
        }
        builder.override().predicate(CelestialEnchantments.loc("book"), 222)
                .model(new ModelFile.UncheckedModelFile(CelestialEnchantments.loc("item/compound_book")))
                .end();
    }
}
