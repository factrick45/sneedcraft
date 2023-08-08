package ihm.sneed.core.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.itemgroup.ItemGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ObserverBlock extends Block {
    public static final DirectionProperty FACING =
        DirectionProperty.of("facing");
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public ObserverBlock() {
        super(Material.STONE);
        this.setStrength(3.5f)
			.setItemGroup(ItemGroup.REDSTONE);
    }

    protected StateManager appendProperties() {
        return new StateManager(this, new Property[] {FACING, POWERED});
    }

    public boolean emitsRedstonePower() { return true; }

    public int getData(BlockState state) {
        int i = 0;

        i |= ((Direction)state.get(FACING)).getId();
        if (((Boolean)state.get(POWERED)).booleanValue())
            i |= 8;

        return i;
    }

    public int getStrongRedstonePower(
        BlockView view, BlockPos pos, BlockState state, Direction facing
    ) {
        return facing != (Direction)state.get(FACING) ? 0
        : !(Boolean)state.get(POWERED)                ? 0
                                                      : 15;
    }

    public int getWeakRedstonePower(
        BlockView view, BlockPos pos, BlockState state, Direction facing
    ) {
        return getStrongRedstonePower(view, pos, state, facing);
    }

    public BlockState stateFromData(int data) {
        return this.getDefaultState()
            .with(FACING, Direction.getById(data & 7))
            .with(POWERED, Boolean.valueOf((data & 8) > 0));
    }

    public void neighborUpdateContextual(
        World world, BlockPos pos, BlockState state, Block block,
        BlockPos source
    ) {
        if (!source.equals(pos.offset((Direction)state.get(FACING))))
            return;
        world.setBlockState(pos, state.with(POWERED, true));
        world.scheduleTick(pos, this, 2, -1);
    }

    public void onPlaced(
        World world, BlockPos pos, BlockState state, LivingEntity placer,
        ItemStack itemStack
    ) {
        // Face the opposite direction of a piston
        Direction dir = PistonBlock.getDirectionFromEntity(world, pos, placer)
                            .getOpposite();
        world.setBlockState(pos, state.with(FACING, dir));
    }

    public void
    onScheduledTick(World world, BlockPos pos, BlockState state, Random rand) {
        world.setBlockState(pos, state.with(POWERED, false));
    }
}
