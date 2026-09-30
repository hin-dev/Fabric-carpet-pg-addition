package tako.carpetorgaddition.mixin;

import carpet.api.settings.SettingsManager;
import tako.carpetorgaddition.settings.PGSettings;
import tako.carpetorgaddition.util.ClientUtils;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SettingsManager.class)
public class SettingsManagerMixin {

    @Inject(method = "lambda$registerCommand$1", at = @At("HEAD"), cancellable = true)
    private static void onRegisterCommand(CommandSourceStack source, CallbackInfoReturnable<Boolean> cir) {
        if (PGSettings.openCarpetCommand) {
            IntegratedServer integratedServer = ClientUtils.getIntegratedServer();
            if (integratedServer != null) {
                cir.setReturnValue(true);
            }
        }
    }
}
