package fr.silenthill99.test_mod.data.models_and_blockstates;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.BISMUTH_BLOCK.get(), cubeAll(ModBlocks.BISMUTH_BLOCK.get()));
        simpleBlockWithItem(ModBlocks.BISMUTH_ORE.get(), cubeAll(ModBlocks.BISMUTH_ORE.get()));
        simpleBlockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), cubeAll(ModBlocks.BISMUTH_DEEPSLATE_ORE.get()));
    }
}
