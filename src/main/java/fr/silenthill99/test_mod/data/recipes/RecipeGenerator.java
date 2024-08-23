package fr.silenthill99.test_mod.data.recipes;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

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

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.BISMUTH_ORE), RecipeCategory.MISC, ModItems.BISMUTH,
                        0.25f, 100)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BISMUTH_ORE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "bismuth_from_blasting_bismuth_ore"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_BISMUTH), RecipeCategory.MISC, ModItems.BISMUTH,
                        0.25f, 100)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_BISMUTH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "bismuth_from_blasting_raw_bismuth"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.BISMUTH_ORE), RecipeCategory.MISC, ModItems.BISMUTH,
                        0.25f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BISMUTH_ORE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "bismuth_from_smelting_bismuth_ore"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_BISMUTH), RecipeCategory.MISC, ModItems.BISMUTH,
                        0.25f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_BISMUTH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, "bismuth_from_smelting_raw_bismuth"));


    }
}
