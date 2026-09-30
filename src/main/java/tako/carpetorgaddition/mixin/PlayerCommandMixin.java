package tako.carpetorgaddition.mixin;

import carpet.commands.PlayerCommand;
import net.minecraft.client.server.IntegratedServer;
import tako.carpetorgaddition.settings.PGSettings;
import tako.carpetorgaddition.util.ClientUtils;
import net.minecraft.commands.CommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerCommand.class)
public class PlayerCommandMixin {

    // 目标方法名可能因 Carpet 版本而变化。
    // 如果注入失败，请反编译 PlayerCommand 类，找到 register 方法中用于权限检查的 lambda 方法名。
    @Inject(method = "lambda$register$0", at = @At("HEAD"), cancellable = true)
    private static void onRegisterPlayerCommand(CommandSourceStack source, CallbackInfoReturnable<Boolean> cir) {
        if (PGSettings.openPlayerCommand) {
            IntegratedServer integratedServer = ClientUtils.getIntegratedServer();
            if (integratedServer != null) {
                cir.setReturnValue(true);
            }
        }
    }
}
