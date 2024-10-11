package fr.silenthill99.test_mod.data.sounds;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.utils.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitionsGenerator extends SoundDefinitionsProvider {

    public SoundDefinitionsGenerator(PackOutput output, ExistingFileHelper helper) {
        super(output, Main.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.SACRIFICED_FLOWERS, SoundDefinition.definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "sacrificed_flowers"))));

    }
}
