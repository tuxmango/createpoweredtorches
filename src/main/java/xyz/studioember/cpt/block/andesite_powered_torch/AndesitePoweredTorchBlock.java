package xyz.studioember.cpt.block.andesite_powered_torch;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import xyz.studioember.cpt.init.ModBlockEntities;

public class AndesitePoweredTorchBlock extends KineticBlock implements IBE<AndesitePoweredTorchBlockEntity> {

    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(5, 0, 5, 11, 9, 11),   // Base
            Block.box(6, 9, 6, 10, 10, 10), // Middle
            Block.box(5, 10, 5, 11, 16, 11) // Bulb
    );

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public AndesitePoweredTorchBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(LIGHT_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIGHT_LEVEL);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == Direction.DOWN;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<AndesitePoweredTorchBlockEntity> getBlockEntityClass() {
        return AndesitePoweredTorchBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends AndesitePoweredTorchBlockEntity> getBlockEntityType() {
        return ModBlockEntities.ANDESITE_POWERED_TORCH.get();
    }
}