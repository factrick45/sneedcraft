package ihm.sneed.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(at = @At("TAIL"), method = "initWidgetsNormal")
    public void onInitWidgets(int y, int spacingY, CallbackInfo ci) {
        TitleScreen ts = ((TitleScreen)(Object)this);
        ts.buttons.add(new ButtonWidget(
            255, ts.width / 2 - 100, y + spacingY * 2, "Sneedcraft"
        ));
        ts.realmsButton.visible = false;
    }

    @Inject(at = @At("HEAD"), method = "buttonClicked")
    protected void onButtonClicked(ButtonWidget button, CallbackInfo ci) {
        if (button.id == 255) {
            System.out.println("Sneed!");
        }
    }
}
