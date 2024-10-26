package fr.silenthill99.test_mod.data;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.trim.ModTrimMaterial;
import fr.silenthill99.test_mod.trim.ModTrimPattern;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterial::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPattern::bootstrap);

    public DatapackGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Main.MODID));
    }
}
