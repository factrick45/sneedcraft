package ihm.sneed.core;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeDispatcher;

public class Recipes {
    public Recipes(RecipeDispatcher rd) {
        rd.registerShapedRecipe(
            new ItemStack(Items.COMPRESSED_COBBLESTONE, 1), "CCC", "CCC", "CCC",
            'C', net.minecraft.block.Blocks.COBBLESTONE
        );
        rd.registerShapelessRecipe(
            new ItemStack(net.minecraft.block.Blocks.COBBLESTONE, 9),
            new ItemStack(Items.COMPRESSED_COBBLESTONE, 1)
        );
        rd.registerShapedRecipe(
            new ItemStack(Items.OBSERVER, 1), "CCC", "RRQ", "CCC", 'C',
            net.minecraft.block.Blocks.COBBLESTONE, 'R',
            net.minecraft.item.Items.REDSTONE, 'Q',
            net.minecraft.item.Items.QUARTZ
        );
    }
}
