package top.andro.not_enough_furniture.util;

import com.google.common.base.Preconditions;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

/**
 * Author: MrCrayfish
 */
public class VoxelShapeHelper {
    public static VoxelShape rotateHorizontally(VoxelShape shape, Direction direction) {
        Preconditions.checkArgument(direction.getAxis().isHorizontal());
        return shape.toAabbs().stream().map(box -> createRotatedShape(box, direction)).reduce(Shapes.empty(), VoxelShapeHelper::join);
    }


    public static VoxelShape combine(List<VoxelShape> shapes) {
        return shapes.stream().reduce(Shapes.empty(), VoxelShapeHelper::join).optimize();
    }

    private static VoxelShape join(VoxelShape a, VoxelShape b) {
        return Shapes.joinUnoptimized(a, b, BooleanOp.OR);
    }

    private static VoxelShape createRotatedShape(AABB box, Direction direction) {
        return switch(direction) {
            case WEST -> Shapes.box(1 - box.maxX, box.minY, 1 - box.maxZ, 1 - box.minX, box.maxY, 1 - box.minZ);
            case NORTH -> Shapes.box(box.minZ, box.minY, 1 - box.maxX, box.maxZ, box.maxY, 1 - box.minX);
            case SOUTH -> Shapes.box(1 - box.maxZ, box.minY, box.minX, 1 - box.minZ, box.maxY, box.maxX);
            default -> Shapes.box(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ);
        };
    }
}
