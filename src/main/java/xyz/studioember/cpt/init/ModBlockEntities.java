package xyz.studioember.cpt.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import xyz.studioember.cpt.Cpt;
import xyz.studioember.cpt.block.andesite_powered_torch.AndesitePoweredTorchBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Cpt.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AndesitePoweredTorchBlockEntity>> ANDESITE_POWERED_TORCH =
            BLOCK_ENTITIES.register("andesite_powered_torch", () ->
                    BlockEntityType.Builder.of(
                            (pos, state) -> new AndesitePoweredTorchBlockEntity(ModBlockEntities.ANDESITE_POWERED_TORCH.get(), pos, state),
                            ModBlocks.ANDESITE_POWERED_TORCH.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}