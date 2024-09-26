package fr.silenthill99.test_mod.data.models;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModBlocks.BISMUTH_DOOR.asItem());
        toolItem(ModItems.BISMUTH_SWORD);
        toolItem(ModItems.BISMUTH_PICKAXE);
        toolItem(ModItems.BISMUTH_SHOVEL);
        toolItem(ModItems.BISMUTH_AXE);
        toolItem(ModItems.BISMUTH_HOE);
    }

    private <T extends Item> void toolItem(DeferredItem<T> item) {
        withExistingParent(item.getId().getPath(), "item/handheld")
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Main.MODID, "item/" + item.getId().getPath()));
    }
}
