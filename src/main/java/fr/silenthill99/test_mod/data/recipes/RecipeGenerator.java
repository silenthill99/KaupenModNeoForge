package fr.silenthill99.test_mod.data.recipes;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import fr.silenthill99.test_mod.utils.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
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

        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f,
                200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f,
                100, "bismuth");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BISMUTH_HAMMER)
                .pattern("000")
                .pattern("000")
                .pattern(" 1 ")
                .define('0', ModItems.BISMUTH)
                .define('1', Items.STICK)
                .unlockedBy(getItemName(ModItems.BISMUTH_HAMMER), InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BISMUTH, Items.STICK))
                .save(recipeOutput);
        trimSmithing(recipeOutput, ModItems.SILENT_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(Main.MODID, "silent"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODWOOD_PLANKS, 4)
                .requires(ModTags.ModItemTags.BLOODWOOD_LOGS)
                .unlockedBy("unlock", has(ModTags.ModItemTags.BLOODWOOD_LOGS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOODWOOD_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.BLOODWOOD_LOG)
                .unlockedBy("unlock", has(ModBlocks.BLOODWOOD_LOG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_BLOODWOOD_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.STRIPPED_BLOODWOOD_LOG)
                .unlockedBy("unlock", has(ModBlocks.STRIPPED_BLOODWOOD_LOG))
                .save(recipeOutput);
    }

    protected static void oreSmelting(
            @NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category,
            @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            @NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category,
            @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            @NotNull RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.@NotNull Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            @NotNull RecipeCategory category,
            @NotNull ItemLike result,
            float experience,
            int cookingTime,
            @NotNull String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime,
                            serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID,
                            getItemName(result) + suffix + "_" + getItemName(itemlike)));
        }
    }
}
