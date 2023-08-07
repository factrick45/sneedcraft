package ihm.sneed.mixin;

import net.minecraft.client.gui.screen.TitleScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(at = @At("HEAD"), method = "render")
    public void
    render(int mouseX, int mouseY, float tickDelta, CallbackInfo info) {
        ((TitleScreen)(Object)this).realmsButton.visible = false;
    }
}