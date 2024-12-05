package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier BISMUTH_TIER = new SimpleTier(ModTags.ModBlockTags.INCORRECT_FOR_BISMUTH_TOOL,
            1400, 4, 3, 28, () -> Ingredient.of(ModItems.BISMUTH.get()));
}
