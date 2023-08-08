package ihm.sneed.core;

import net.minecraft.block.Block;

import ihm.sneed.core.blocks.*;

public class Blocks {
    public static final Block COMPRESSED_COBBLESTONE =
        new CompressedCobblestoneBlock();
    public static final Block OBSERVER = new ObserverBlock();

    public Blocks() {
        Reg.block("compressed_cobblestone", COMPRESSED_COBBLESTONE);
        Reg.block("observer", OBSERVER);
    }
}
