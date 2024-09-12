package fr.silenthill99.test_mod.data.recipes;

import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    List<ItemLike> BISMUTH_SMELTABLES = List.of(
            ModItems.RAW_BISMUTH,
            ModBlocks.BISMUTH_ORE,
            ModBlocks.BISMUTH_DEEPSLATE_ORE
    );

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BISMUTH, 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BISMUTH_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BISMUTH))
                .save(recipeOutput);

        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200,
                "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100,
                "bismuth");

    }
}
