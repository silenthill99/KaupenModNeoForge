package fr.silenthill99.test_mod.data;

import com.google.common.eventbus.Subscribe;
import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.data.models_and_blockstates.ItemModelGenerator;
import fr.silenthill99.test_mod.data.recipes.RecipeGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Main.MODID, bus= EventBusSubscriber.Bus.MOD)
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
        generator.addProvider(serveur, new RecipeGenerator(packOutput, lookupProvider));
    }
}
