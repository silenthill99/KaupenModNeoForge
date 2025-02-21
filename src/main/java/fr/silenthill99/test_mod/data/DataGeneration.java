package fr.silenthill99.test_mod.data;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.data.data_maps.DataMapGenerator;
import fr.silenthill99.test_mod.data.loot_tables.LootTableGenerator;
import fr.silenthill99.test_mod.data.models.BlockStateGenerator;
import fr.silenthill99.test_mod.data.models.ItemModelGenerator;
import fr.silenthill99.test_mod.data.packs.DatapackGenerator;
import fr.silenthill99.test_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.test_mod.data.sounds.SoundDefinitionsGenerator;
import fr.silenthill99.test_mod.data.tags.BlockTagGenerator;
import fr.silenthill99.test_mod.data.tags.ItemTagsGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        boolean client = event.includeClient();
        boolean serveur = event.includeServer();

        generator.addProvider(client, new ItemModelGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new BlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(client, new SoundDefinitionsGenerator(packOutput, existingFileHelper));

        generator.addProvider(serveur, new RecipeGenerator(packOutput, lookupProvider));
        generator.addProvider(serveur, new LootTableGenerator(packOutput, lookupProvider));
        BlockTagGenerator blockTagGenerator = generator.addProvider(serveur, new BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(serveur, new ItemTagsGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));
        generator.addProvider(serveur, new DataMapGenerator(packOutput, lookupProvider));
        generator.addProvider(serveur, new DatapackGenerator(packOutput, lookupProvider));
    }
}
