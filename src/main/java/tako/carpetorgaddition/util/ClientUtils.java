package tako.carpetorgaddition.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;

public class ClientUtils {
    public static IntegratedServer getIntegratedServer() {
        Minecraft client = Minecraft.getInstance();
        if (client != null) {
            return client.getSingleplayerServer();
        }
        return null;
    }
}
