package fr.silenthill99.test_mod.data.loot_tables;

import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


    @Override
    protected void generate() {
        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), block -> createDropLikeCopperOre(block, ModItems.RAW_BISMUTH.get(), 2, 5));
        add(ModBlocks.BISMUTH_ORE.get(), block -> createDropLikeCopperOre(block, ModItems.RAW_BISMUTH.get(), 2, 5));
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.BISMUTH_STAIRS.get());
        add(ModBlocks.BISMUTH_SLAB.get(), this::createSlabItemTable);
        dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BISMUTH_BUTTON.get());
        dropSelf(ModBlocks.BISMUTH_FENCE.get());
        dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        dropSelf(ModBlocks.BISMUTH_WALL.get());
        add(ModBlocks.BISMUTH_DOOR.get(), this::createDoorTable);
        dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
        dropSelf(ModBlocks.BISMUTH_LAMP.get());
        add(ModBlocks.BISMUTH_END_ORE.get(), block -> createDropLikeCopperOre(block, ModItems.RAW_BISMUTH.get(), 3, 6));
        add(ModBlocks.BISMUTH_NETHER_ORE.get(), block -> createDropLikeCopperOre(block, ModItems.RAW_BISMUTH.get(), 4, 8));

        dropSelf(ModBlocks.BLOODWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_BLOODWOOD_LOG.get());
        dropSelf(ModBlocks.BLOODWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_BLOODWOOD_LOG.get());
        dropSelf(ModBlocks.BLOODWOOD_PLANKS.get());
        dropSelf(ModBlocks.BLOODWOOD_SAPLING.get());

        add(ModBlocks.BLOODWOOD_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.BLOODWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(DeferredHolder::get)
                .collect(Collectors.toList());
    }

    protected LootTable.Builder createDropLikeCopperOre(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

}
