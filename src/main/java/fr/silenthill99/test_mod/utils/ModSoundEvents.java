package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MODID);

    public static final ResourceKey<JukeboxSong> SACRIFICED_FLOWERS = registerSoundEvent("sacrificed_flowers");
    private static ResourceKey<JukeboxSong> registerSoundEvent(String name) {
        SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Main.MODID, name)));
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Main.MODID, "sacrificed_flowers"));
    }
//    public static class ModjukeboxSongs {
//        public static final ResourceKey<JukeboxSong> SACRIFICED_FLOWERS =
//    }
}
