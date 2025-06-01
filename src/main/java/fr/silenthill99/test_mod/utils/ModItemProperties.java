package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.components.ModDataComponents;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(Main.MODID, "used"),
                (stack, properties, level, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0);
        addCustomBow(ModItems.KAUPEN_BOW.get());
    }

    private static void addCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (ClampedItemPropertyFunction)((itemStack, level, entity, value) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        }));
        
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pulling"), (ClampedItemPropertyFunction)((itemStack, level, entity, value) -> entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0F : 0.0F));
    }
}
