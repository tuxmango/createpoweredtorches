package xyz.studioember.cpt;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = CreatePoweredTorches.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CreatePoweredTorches.MODID, value = Dist.CLIENT)
public class CreatePoweredTorchesClient {
    public CreatePoweredTorchesClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CreatePoweredTorches.LOGGER.info("HELLO FROM CLIENT SETUP");
    }
}
