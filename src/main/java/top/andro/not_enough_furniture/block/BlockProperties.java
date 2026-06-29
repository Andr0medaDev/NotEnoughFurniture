package top.andro.not_enough_furniture.block;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public interface BlockProperties {
    BooleanProperty NORTH = BlockStateProperties.NORTH;
    BooleanProperty EAST = BlockStateProperties.EAST;
    BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    BooleanProperty WEST = BlockStateProperties.WEST;
    BooleanProperty LEFT = BooleanProperty.create("left");
    BooleanProperty RIGHT = BooleanProperty.create("right");
    BooleanProperty OPEN = BlockStateProperties.OPEN;
    DirectionProperty FACING = BlockStateProperties.FACING;
}
