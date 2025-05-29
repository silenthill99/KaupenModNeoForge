package fr.silenthill99.test_mod.data;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.data.data_maps.DataMapGenerator;
import fr.silenthill99.test_mod.data.loot_tables.LootTableGenerator;
import fr.silenthill99.test_mod.data.models.BlockStateGenerator;
import fr.silenthill99.test_mod.data.models.ItemModelGenerator;
import fr.silenthill99.test_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.test_mod.data.sounds.SoundDefinitionsGenerator;
import fr.silenthill99.test_mod.data.tags.BlockTagGenerator;
import fr.silenthill99.test_mod.data.tags.ItemTagsGenerator;
import fr.silenthill99.test_mod.trim.ModTrimMaterial;
import fr.silenthill99.test_mod.trim.ModTrimPattern;
import fr.silenthill99.test_mod.utils.ModSoundEvents;
import fr.silenthill99.test_mod.worldgen.ModBiomeModifiers;
import fr.silenthill99.test_mod.worldgen.ModConfiguredFeatures;
import fr.silenthill99.test_mod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {

        boolean client = event.includeClient();
        boolean serveur = event.includeServer();

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(client, new ItemModelGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new BlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new SoundDefinitionsGenerator(packOutput, existingFileHelper));

        generator.addProvider(serveur, new RecipeGenerator(packOutput, lookupProvider));
        generator.addProvider(serveur, new LootTableGenerator(packOutput, lookupProvider));
        BlockTagGenerator blockTagGenerator = generator.addProvider(serveur, new BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(serveur, new ItemTagsGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));
        generator.addProvider(serveur, new DataMapGenerator(packOutput, lookupProvider));
        generator.addProvider(serveur, new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, new RegistrySetBuilder()
                .add(Registries.JUKEBOX_SONG, bootstrap -> {
                    bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.SACRIFICED_FLOWERS),
                            new JukeboxSong(ModSoundEvents.SACRIFICED_FLOWERS,
                                    Component.translatable("jukebox.test_mod.sacrificed_flowers"),
                                    5260,
                                    0));
                    bootstrap.register(ModSoundEvents.convertToJukeboxSong(ModSoundEvents.BAR_BRAWL),
                            new JukeboxSong(ModSoundEvents.BAR_BRAWL,
                                    Component.translatable("item.test_mod.bar_brawl_music_disc.desc"),
                                    162,
                                    15));

                })
                .add(Registries.TRIM_MATERIAL, ModTrimMaterial::bootstrap)
                .add(Registries.TRIM_PATTERN, ModTrimPattern::bootstrap)

                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap),
                Set.of(Main.MODID))
        );
    }
}
