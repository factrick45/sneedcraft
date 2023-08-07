package ihm.sneed.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public class WorldMixin {
    @Inject(at = @At("HEAD"), method = "updateNeighborsAlways")
    public void
    onUpdateNeighbors(BlockPos pos, Block block, CallbackInfo info) {
        World world = (World)(Object)this;

        updateNeighborContextual(pos.west(), block, pos);
        updateNeighborContextual(pos.east(), block, pos);
        updateNeighborContextual(pos.down(), block, pos);
        updateNeighborContextual(pos.up(), block, pos);
        updateNeighborContextual(pos.north(), block, pos);
        updateNeighborContextual(pos.south(), block, pos);
    }

    public void
    updateNeighborContextual(BlockPos target, Block block, BlockPos source) {
        World world = (World)(Object)this;
        BlockState state = world.getBlockState(target);

        state.getBlock().neighborUpdateContextual(
            world, target, state, block, source
        );
    }
}
