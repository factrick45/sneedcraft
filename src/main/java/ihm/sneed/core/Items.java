package ihm.sneed.core;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class Items {
    public static final Item COMPRESSED_COBBLESTONE =
        new BlockItem(Blocks.COMPRESSED_COBBLESTONE);
    public static final Item OBSERVER = new BlockItem(Blocks.OBSERVER);

    public Items() {
        Reg.item("compressed_cobblestone", COMPRESSED_COBBLESTONE);
        Reg.item("observer", OBSERVER);
    }
}
