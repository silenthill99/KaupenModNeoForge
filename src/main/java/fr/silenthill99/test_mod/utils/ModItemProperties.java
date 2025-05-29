package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.components.ModDataComponents;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(Main.MODID, "used"),
                (stack, properties, level, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0);
    }
}
