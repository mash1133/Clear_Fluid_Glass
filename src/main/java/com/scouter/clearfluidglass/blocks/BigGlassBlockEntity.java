package com.scouter.clearfluidglass.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public abstract class BigGlassBlockEntity extends BaseEntityBlock {
    protected BigGlassBlockEntity(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, Boolean.valueOf(false))
                .setValue(DOWN, Boolean.valueOf(false))
                .setValue(EAST, Boolean.valueOf(false))
                .setValue(WEST, Boolean.valueOf(false))
                .setValue(NORTH, Boolean.valueOf(false))
                .setValue(SOUTH, Boolean.valueOf(false)));
    }

    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_58032_) {
        p_58032_.add(UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader levelreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos n = blockpos.north();
        BlockPos e = blockpos.east();
        BlockPos s = blockpos.south();
        BlockPos w = blockpos.west();
        BlockPos u = blockpos.above();
        BlockPos d = blockpos.below();
        BlockState northState = levelreader.getBlockState(n);
        BlockState eastState = levelreader.getBlockState(e);
        BlockState southState = levelreader.getBlockState(s);
        BlockState westState = levelreader.getBlockState(w);
        BlockState upState = levelreader.getBlockState(u);
        BlockState downState = levelreader.getBlockState(d);
        return defaultBlockState().setValue(NORTH, northState.is(this)).setValue(NORTH, northState.is(this)).setValue(EAST, eastState.is(this)).setValue(SOUTH, southState.is(this)).setValue(WEST, westState.is(this)).setValue(UP, upState.is(this)).setValue(DOWN, downState.is(this));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor levelreader, BlockPos blockpos, BlockPos pos2) {
        BlockPos n = blockpos.north();
        BlockPos e = blockpos.east();
        BlockPos s = blockpos.south();
        BlockPos w = blockpos.west();
        BlockPos u = blockpos.above();
        BlockPos d = blockpos.below();
        BlockState northState = levelreader.getBlockState(n);
        BlockState eastState = levelreader.getBlockState(e);
        BlockState southState = levelreader.getBlockState(s);
        BlockState westState = levelreader.getBlockState(w);
        BlockState upState = levelreader.getBlockState(u);
        BlockState downState = levelreader.getBlockState(d);
        return state.setValue(NORTH, northState.is(this)).setValue(NORTH, northState.is(this)).setValue(EAST, eastState.is(this)).setValue(SOUTH, southState.is(this)).setValue(WEST, westState.is(this)).setValue(UP, upState.is(this)).setValue(DOWN, downState.is(this));
    }
}
