package xyz.studioember.cpt.init;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.studioember.cpt.Cpt;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Cpt.MOD_ID);

//    public static final DeferredItem<Item> XAENON_INGOT = ITEMS.register("xaenon_ingot",
//            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
