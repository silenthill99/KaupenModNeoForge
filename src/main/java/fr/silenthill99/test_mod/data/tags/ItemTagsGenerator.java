package fr.silenthill99.test_mod.data.tags;

import fr.silenthill99.test_mod.init.ModItems;
import fr.silenthill99.test_mod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
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
    }
}
