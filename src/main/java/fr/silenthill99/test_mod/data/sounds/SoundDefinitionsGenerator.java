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

        add(ModSoundEvents.CHISEL_USE, SoundDefinition.definition()
                .subtitle("sounds.test_mod.chisel_use")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "chisel_use"))));
        add(ModSoundEvents.MAGIC_BLOCK_BREAK, SoundDefinition.definition()
                .subtitle("sounds.test_mod.magic_block_break")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "magic_block_break"))));
        add(ModSoundEvents.MAGIC_BLOCK_STEP, SoundDefinition.definition()
                .subtitle("sounds.test_mod.magic_block_step")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "magic_block_step"))));
        add(ModSoundEvents.MAGIC_BLOCK_PLACE, SoundDefinition.definition()
                .subtitle("sounds.test_mod.magic_block_place")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "magic_block_place"))));
        add(ModSoundEvents.MAGIC_BLOCK_HIT, SoundDefinition.definition()
                .subtitle("sounds.test_mod.magic_block_hit")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "magic_block_hit"))));
        add(ModSoundEvents.MAGIC_BLOCK_FALL, SoundDefinition.definition()
                .subtitle("sounds.test_mod.magic_block_fall")
                .with(sound(ResourceLocation.fromNamespaceAndPath(Main.MODID, "magic_block_fall"))));
    }
}
