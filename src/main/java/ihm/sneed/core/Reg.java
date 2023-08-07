package ihm.sneed.core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.itemgroup.ItemGroup;

import net.legacyfabric.fabric.api.registry.v1.RegistryHelper;
import net.legacyfabric.fabric.api.util.Identifier;

public class Reg {
    public static final String NAMESPACE = "sneed";

    public static void block(String id, Block block) {
        RegistryHelper.registerBlock(block, new Identifier(NAMESPACE, id));
    }

    public static void block(String id, Block block, boolean item) {
        Identifier fid = new Identifier(NAMESPACE, id);
        RegistryHelper.registerBlock(block, fid);
        if (!item)
            return;
        RegistryHelper.registerItem(new BlockItem(block), fid);
    }

    public static void item(String id, Item item) {
        RegistryHelper.registerItem(item, new Identifier(NAMESPACE, id));
    }

    public Reg() { new Blocks(); }
}
