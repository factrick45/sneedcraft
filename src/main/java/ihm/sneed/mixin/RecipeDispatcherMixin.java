package ihm.sneed.mixin;

import net.minecraft.recipe.RecipeDispatcher;

import ihm.sneed.core.Recipes;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeDispatcher.class)
public class RecipeDispatcherMixin {
    @Inject(at = @At("TAIL"), method = "<init>")
    private void onRegisterRecipes(CallbackInfo ci) {
        new Recipes((RecipeDispatcher)(Object)this);
    }
}
