package fr.silenthill99.test_mod.worldgen.tree;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import org.antlr.v4.runtime.tree.Tree;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BLOODWOOD = new TreeGrower(ResourceLocation.fromNamespaceAndPath(Main.MODID, "bloodwood").toString(),
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOODWOOD_KEY), Optional.empty());
}
