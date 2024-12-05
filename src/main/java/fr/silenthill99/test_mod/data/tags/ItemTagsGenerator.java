package fr.silenthill99.test_mod.data.tags;

import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import fr.silenthill99.test_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ItemTagsGenerator extends ItemTagsProvider {
    public ItemTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                             CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.ModItemTags.TRANSFORMABLE_ITEMS).add(
                ModItems.BISMUTH.get(),
                ModItems.RAW_BISMUTH.get(),
                Items.COAL,
                Items.STICK,
                Items.COMPASS
        );
        tag(ItemTags.SWORDS).add(
                ModItems.BISMUTH_SWORD.get()
        );
        tag(ItemTags.PICKAXES).add(
                ModItems.BISMUTH_PICKAXE.get()
        );
        tag(ItemTags.SHOVELS).add(
                ModItems.BISMUTH_SHOVEL.get()
        );
        tag(ItemTags.AXES).add(
                ModItems.BISMUTH_AXE.get()
        );
        tag(ItemTags.HOES).add(
                ModItems.BISMUTH_HOE.get()
        );
        tag(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.BISMUTH_HELMET.get(),
                ModItems.BISMUTH_CHESTPLATE.get(),
                ModItems.BISMUTH_LEGGINGS.get(),
                ModItems.BISMUTH_BOOTS.get()
        );
        tag(ItemTags.TRIM_MATERIALS).add(
                ModItems.BISMUTH.get()
        );
        tag(ItemTags.TRIM_TEMPLATES).add(
                ModItems.SILENT_SMITHING_TEMPLATE.get()
        );

        tag(ItemTags.LOGS_THAT_BURN).add(
                ModBlocks.BLOODWOOD_LOG.asItem(),
                ModBlocks.BLOODWOOD_WOOD.asItem(),
                ModBlocks.STRIPPED_BLOODWOOD_LOG.asItem(),
                ModBlocks.STRIPPED_BLOODWOOD_WOOD.asItem()
        );

        tag(ItemTags.PLANKS).add(
                ModBlocks.BLOODWOOD_PLANKS.asItem()
        );

        tag(ModTags.ModItemTags.BLOODWOOD_LOGS).add(
                ModBlocks.BLOODWOOD_LOG.asItem(),
                ModBlocks.STRIPPED_BLOODWOOD_LOG.asItem(),
                ModBlocks.BLOODWOOD_WOOD.asItem(),
                ModBlocks.STRIPPED_BLOODWOOD_WOOD.asItem()
        );
    }
}
