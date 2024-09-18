package fr.silenthill99.test_mod.data.models;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;


public class BlockStateGenerator extends BlockStateProvider {
    private String path;

    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.BISMUTH_BLOCK.get(), cubeAll(ModBlocks.BISMUTH_BLOCK.get()));
        simpleBlockWithItem(ModBlocks.BISMUTH_ORE.get(), cubeAll(ModBlocks.BISMUTH_ORE.get()));
        simpleBlockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), cubeAll(ModBlocks.BISMUTH_DEEPSLATE_ORE.get()));
        simpleBlockWithItem(ModBlocks.MAGIC_BLOCK.get(), cubeAll(ModBlocks.MAGIC_BLOCK.get()));
        stairsBlock(ModBlocks.BISMUTH_STAIRS.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        slabBlock(ModBlocks.BISMUTH_SLAB.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        pressurePlateBlock(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        buttonBlock(ModBlocks.BISMUTH_BUTTON.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceBlock(ModBlocks.BISMUTH_FENCE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceGateBlock(ModBlocks.BISMUTH_FENCE_GATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        wallBlock(ModBlocks.BISMUTH_WALL.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.BISMUTH_DOOR.get(), modLoc("block/bismuth_door_bottom"),
                modLoc("block/bismuth_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(), modLoc("block/bismuth_trapdoor"),
                true, "cutout");
    }

    @Override
    public void stairsBlock(@NotNull StairBlock block, @NotNull ResourceLocation texture) {
        super.stairsBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
    }

    @Override
    public void slabBlock(@NotNull SlabBlock block, @NotNull ResourceLocation doubleslab,
                          @NotNull ResourceLocation texture) {
        super.slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
    }

    @Override
    public void pressurePlateBlock(@NotNull PressurePlateBlock block, @NotNull ResourceLocation texture) {
        super.pressurePlateBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
    }

    @Override
    public void buttonBlock(@NotNull ButtonBlock block, @NotNull ResourceLocation texture) {
        super.buttonBlock(block, texture);
        path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        simpleBlockItem(block, models().buttonInventory(path + "_inventory", texture));
    }

    @Override
    public void fenceBlock(@NotNull FenceBlock block, @NotNull ResourceLocation texture) {
        super.fenceBlock(block, texture);
        path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        simpleBlockItem(block, models().fenceInventory(path + "_inventory", texture));
    }

    @Override
    public void fenceGateBlock(@NotNull FenceGateBlock block, @NotNull ResourceLocation texture) {
        super.fenceGateBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(blockTexture(block)));
    }

    @Override
    public void wallBlock(@NotNull WallBlock block, @NotNull ResourceLocation texture) {
        super.wallBlock(block, texture);
        path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        simpleBlockItem(block, models().wallInventory(path + "_inventory", texture));
    }

    @Override
    public void trapdoorBlockWithRenderType(@NotNull TrapDoorBlock block, @NotNull ResourceLocation texture,
                                            boolean orientable, @NotNull String renderType) {
        super.trapdoorBlockWithRenderType(block, texture, orientable, renderType);
        path = BuiltInRegistries.BLOCK.getKey(block).getPath();
        simpleBlockItem(block, models().trapdoorOrientableBottom(path + "_bottom", texture));
    }
}
