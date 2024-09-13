package fr.silenthill99.test_mod.data.models;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BISMUTH);
        simpleItem(ModItems.RAW_BISMUTH);
        simpleItem(ModItems.CHISEL);
        simpleItem(ModItems.RADISH);
        simpleItem(ModItems.FROSTFIRE_ICE);
        simpleItem(ModItems.STARLIGHT_ASHES);
        basicItem(ModBlocks.BISMUTH_DOOR.asItem());
    }

    private void simpleItem(DeferredItem<Item> item) {
        withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }
}
