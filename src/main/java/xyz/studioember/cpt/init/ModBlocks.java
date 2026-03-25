package xyz.studioember.cpt.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.studioember.cpt.Cpt;
import xyz.studioember.cpt.block.andesite_powered_torch.AndesitePoweredTorchBlock;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cpt.MOD_ID);

    public static final DeferredBlock<AndesitePoweredTorchBlock> ANDESITE_POWERED_TORCH = registerBlock("andesite_powered_torch",
            () -> new AndesitePoweredTorchBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .lightLevel(state -> state.getValue(AndesitePoweredTorchBlock.LIGHT_LEVEL))));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> deferred = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(deferred.get(), new Item.Properties()));
        return deferred;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}