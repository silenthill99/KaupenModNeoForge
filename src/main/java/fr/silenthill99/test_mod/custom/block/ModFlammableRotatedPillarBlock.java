package fr.silenthill99.test_mod.custom.block;

import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    private static Map<Block, Block> flammables = Map.of(
            ModBlocks.BLOODWOOD_LOG.get(), ModBlocks.STRIPPED_BLOODWOOD_LOG.get(),
            ModBlocks.BLOODWOOD_WOOD.get(), ModBlocks.STRIPPED_BLOODWOOD_WOOD.get()
    );

    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {

            for (Map.Entry<Block, Block> entries : flammables.entrySet()) {
                Block entry = entries.getKey();
                Block value = entries.getValue();

                if (state.is(entry)) {
                    return value.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }
//            if (state.is(ModBlocks.BLOODWOOD_LOG)) {
//                return ModBlocks.STRIPPED_BLOODWOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
//            }
//            if (state.is(ModBlocks.BLOODWOOD_WOOD)) {
//                return ModBlocks.STRIPPED_BLOODWOOD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
//            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
