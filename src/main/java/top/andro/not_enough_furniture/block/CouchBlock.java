package top.andro.not_enough_furniture.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import top.andro.not_enough_furniture.entity.CouchSeatEntity;
import top.andro.not_enough_furniture.entity.SeatEntity;
import top.andro.not_enough_furniture.init.ModEntities;
import top.andro.not_enough_furniture.util.Utils;
import top.andro.not_enough_furniture.util.VoxelShapeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: MrCrayfish
 */

public class CouchBlock extends RotatedFurnitureBlock {
    private static final MapCodec<CouchBlock> CODEC = RecordCodecBuilder.mapCodec(builder -> {
        return builder.group(DyeColor.CODEC.fieldOf("color").forGetter(block -> {
            return block.color;
        }), propertiesCodec()).apply(builder, CouchBlock::new);
    });

    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);

    private final DyeColor color;

    public CouchBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
    }

    public DyeColor getDyeColor() {
        return this.color;
    }

    @Override
    protected MapCodec<CouchBlock> codec() {
        return CODEC;
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        VoxelShape baseShape = Block.box(0, 0, 0, 16, 7, 16);
        VoxelShape leftArmShape = Block.box(0, 6, 14, 14, 11, 19);
        VoxelShape rightArmShape = Block.box(0, 6, -3, 14, 11, 2);
        VoxelShape backShape = Block.box(12, 7, 0, 16, 17, 16);
        return ImmutableMap.copyOf(states.stream().collect(Collectors.toMap(state -> state, state -> {
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(baseShape);
            shapes.add(backShape);
            switch(state.getValue(SHAPE)) {
                case DEFAULT -> {
                    shapes.add(leftArmShape);
                    shapes.add(rightArmShape);
                }
                case LEFT -> {
                    shapes.add(rightArmShape);
                }
                case RIGHT -> {
                    shapes.add(leftArmShape);
                }
                case CORNER_LEFT -> {
                    shapes.add(VoxelShapeHelper.rotateHorizontally(backShape, Direction.NORTH));
                }
                case CORNER_RIGHT -> {
                    shapes.add(VoxelShapeHelper.rotateHorizontally(backShape, Direction.SOUTH));
                }
            }
            return VoxelShapeHelper.rotateHorizontally(VoxelShapeHelper.combine(shapes), state.getValue(DIRECTION));
        })));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null) {
            return state.setValue(SHAPE, this.getShape(state, context.getLevel(), context.getClickedPos()));
        }
        return null;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<CouchSeatEntity> entities = level.getEntities(ModEntities.COUCH_SEAT.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.COUCH_SEAT.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos) {
        return state.setValue(SHAPE, this.getShape(state, level, pos));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHAPE);
    }

    public Shape getShape(BlockState state, LevelAccessor level, BlockPos pos) {
        Direction facing = state.getValue(DIRECTION);
        Direction front = this.getCouchDirection(level, pos, facing.getOpposite());
        if(front != null) {
            if(front == facing.getClockWise()) {
                return Shape.CORNER_RIGHT;
            }
            else if(front == facing.getCounterClockWise()) {
                return Shape.CORNER_LEFT;
            }
        }
        boolean left = this.isConnectable(level, pos, facing, facing.getCounterClockWise());
        boolean right = this.isConnectable(level, pos, facing, facing.getClockWise());
        if(left && right) {
            return Shape.MIDDLE;
        }
        else if(left) {
            return Shape.RIGHT;
        }
        else if(right) {
            return Shape.LEFT;
        }
        return Shape.DEFAULT;
    }

    private Direction getCouchDirection(LevelAccessor level, BlockPos pos, Direction side) {
        BlockState relativeState = level.getBlockState(pos.relative(side));
        return relativeState.getBlock() instanceof CouchBlock ? relativeState.getValue(DIRECTION) : null;
    }

    private boolean isConnectable(LevelAccessor level, BlockPos pos, Direction facing, Direction offset) {
        BlockPos relativePos = pos.relative(offset);
        BlockState relativeState = level.getBlockState(pos.relative(offset));
        if(relativeState.getBlock() instanceof CouchBlock) {
            Direction other = relativeState.getValue(DIRECTION);
            return other == facing || other == offset;
        }
        return relativeState.isFaceSturdy(level, relativePos, offset.getOpposite());
    }

    /*public List<TagKey<Block>> getTags() {
        return List.of(BlockTags.MINEABLE_WITH_AXE);
    }*/

    public enum Shape implements StringRepresentable {
        DEFAULT("default"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right");

        private final String name;

        Shape(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
