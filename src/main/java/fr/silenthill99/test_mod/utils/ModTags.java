package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class ModBlockTags {
        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createtag("needs_bismuth_tool");
        public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createtag("incorrect_for_bismuth_tool");

        private static TagKey<Block> createtag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }

    }

    public static class ModItemTags {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Main.MODID, name));
        }

    }
}
