package ihm.sneed.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

import ihm.sneed.core.Reg;
import ihm.sneed.core.blocks.*;

public class Blocks {
    public static final Block TEST =
        new Block(Material.STONE, MaterialColor.PURPLE);
    public static final Block OBSERVER = new ObserverBlock();

    public Blocks() {
        Reg.block("test", TEST, true);
        Reg.block("observer", OBSERVER, true);
    }
}
