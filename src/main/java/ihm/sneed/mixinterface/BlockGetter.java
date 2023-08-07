package ihm.sneed.mixinterface;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface BlockGetter {
    default void neighborUpdateContextual(
        World world, BlockPos pos, BlockState state, Block block,
        BlockPos source
    ) {}
}
