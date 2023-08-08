package ihm.sneed.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.itemgroup.ItemGroup;

public class CompressedCobblestoneBlock extends Block {
    public CompressedCobblestoneBlock() {
        super(Material.STONE);
        this.setStrength(3.5f).setItemGroup(ItemGroup.BUILDING_BLOCKS);
    }

    // Can't be pushed by pistons
    public int getPistonInteractionType() { return 2; }
}
