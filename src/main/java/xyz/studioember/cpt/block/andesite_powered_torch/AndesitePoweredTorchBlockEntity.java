package xyz.studioember.cpt.block.andesite_powered_torch;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AndesitePoweredTorchBlockEntity extends KineticBlockEntity {

    private int lastLightLevel = 0;

    public AndesitePoweredTorchBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void tick() {
        super.tick();

        if (level != null && !level.isClientSide) {
            float speed = Math.abs(getSpeed());
            int targetLight = (int) Math.min(15, speed / 16f);

            BlockState currentState = getBlockState();
            if (currentState.hasProperty(AndesitePoweredTorchBlock.LIGHT_LEVEL) &&
                    currentState.getValue(AndesitePoweredTorchBlock.LIGHT_LEVEL) != targetLight) {

                level.setBlock(worldPosition, currentState.setValue(AndesitePoweredTorchBlock.LIGHT_LEVEL, targetLight), 3);
            }
        }
    }

    public int getLightEmission() {
        return lastLightLevel;
    }
}