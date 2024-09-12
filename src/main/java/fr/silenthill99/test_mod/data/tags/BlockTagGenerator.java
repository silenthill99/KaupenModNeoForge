package fr.silenthill99.test_mod.data.tags;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.BISMUTH_BLOCK.get(),
                ModBlocks.BISMUTH_ORE.get(),
                ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                ModBlocks.MAGIC_BLOCK.get()
        );
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.BISMUTH_ORE.get()
        );
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.BISMUTH_DEEPSLATE_ORE.get()
        );
    }
}
