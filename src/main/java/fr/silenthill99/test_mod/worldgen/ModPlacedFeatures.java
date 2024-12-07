package fr.silenthill99.test_mod.worldgen;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BISMUTH_ORE_PLACEMENT_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_BISMUTH_ORE_PLACEMENT_KEY = registerKey("nether_bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> END_BISMUTH_ORE_PLACEMENT_KEY = registerKey("end_bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> BLOODWOOD_PLACED_KEY = registerKey("bloodwood_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BISMUTH_ORE_PLACEMENT_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NETHER_BISMUTH_ORE_PLACEMENT_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, END_BISMUTH_ORE_PLACEMENT_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BISMUTH_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, BLOODWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOODWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.BLOODWOOD_SAPLING.get()));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
