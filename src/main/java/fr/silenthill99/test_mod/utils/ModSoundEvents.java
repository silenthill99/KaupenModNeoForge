package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SACRIFICED_FLOWERS = SOUNDS.register("sacrificed_flowers",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Main.MODID, "sacrificed_flowers")));

    public static ResourceKey<JukeboxSong> convertToJukeboxSong(DeferredHolder<SoundEvent, SoundEvent> sounds) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Main.MODID, sounds.getId().getPath()));
    }
}
