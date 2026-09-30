package tako.carpetorgaddition;

import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;

public class CarpetPGAddition implements ModInitializer {
    @Override
    public void onInitialize() {
        CarpetServer.manageExtension(new CarpetPGExtension());
    }
}
