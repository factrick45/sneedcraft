package ihm.sneed.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import ihm.sneed.mixinterface.BlockGetter;

import org.spongepowered.asm.mixin.Mixin;

@Mixin(Block.class)
public class BlockMixin implements BlockGetter {
    @Override
    public void neighborUpdateContextual(
        World world, BlockPos pos, BlockState state, Block block,
        BlockPos source
    ) {}
}
