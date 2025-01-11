package fr.silenthill99.test_mod.custom.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChairBlock extends HorizontalDirectionalBlock {

    public static final MapCodec<ChairBlock> CODEC = simpleCodec(ChairBlock::new);

    public VoxelShape SHAPE_SOUTH(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.203125, 0.8125, 0.4375, 0.328125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.203125, 0.3125, 0.4375, 0.328125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.703125, 0.3125, 0.4375, 0.828125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.703125, 0.8125, 0.4375, 0.828125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.18125000000000002, 0.4375, 0.203125, 0.81875, 0.5, 0.859375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.5, 0.203125, 0.8125, 1.1875, 0.296875), BooleanOp.OR);

        return shape;
    }

    public VoxelShape SHAPE_NORTH(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.6875, 0.3125, 0.4375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.6875, 0.8125, 0.4375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.1875, 0.8125, 0.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.1875, 0.3125, 0.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.18125, 0.4375, 0.15625, 0.81875, 0.5, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.5, 0.71875, 0.8125, 1.1875, 0.8125), BooleanOp.OR);

        return shape;
    }

    public VoxelShape SHAPE_EAST(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.1953125, 0, 0.1953125, 0.3203125, 0.4375, 0.3203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1953125, 0, 0.6953125, 0.3203125, 0.4375, 0.8203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6953125, 0, 0.6953125, 0.8203125, 0.4375, 0.8203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6953125, 0, 0.1953125, 0.8203125, 0.4375, 0.3203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1953125, 0.4375, 0.18906250000000002, 0.8515625, 0.5, 0.8265625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1953125, 0.5, 0.1953125, 0.2890625, 1.1875, 0.8203125), BooleanOp.OR);

        return shape;
    }

    public VoxelShape SHAPE_WEST(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.6796875, 0, 0.6953125, 0.8046875, 0.4375, 0.8203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6796875, 0, 0.1953125, 0.8046875, 0.4375, 0.3203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1796875, 0, 0.1953125, 0.3046875, 0.4375, 0.3203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1796875, 0, 0.6953125, 0.3046875, 0.4375, 0.8203125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1484375, 0.4375, 0.18906250000000002, 0.8046875, 0.5, 0.8265625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.7109375, 0.5, 0.1953125, 0.8046875, 1.1875, 0.8203125), BooleanOp.OR);

        return shape;
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        switch (state.getValue(FACING)) {
            case SOUTH -> {
                return SHAPE_SOUTH();
            }
            case EAST -> {
                return SHAPE_EAST();
            }
            case WEST -> {
                return SHAPE_WEST();
            }
            default -> {
                return SHAPE_NORTH();
            }
        }
    }

    public ChairBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
