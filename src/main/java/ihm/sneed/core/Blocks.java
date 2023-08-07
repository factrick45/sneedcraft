package ihm.sneed.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import ihm.sneed.core.Reg;

public class Blocks {
    public static final Block TEST =
        new Block(Material.STONE, MaterialColor.PURPLE);

    public Blocks() { Reg.block("test", TEST, true); }
}
