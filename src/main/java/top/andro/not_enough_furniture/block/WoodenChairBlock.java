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
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import net.minecraft.world.level.block.state.properties.DirectionProperty;
import top.andro.not_enough_furniture.entity.SeatEntity;
import top.andro.not_enough_furniture.init.ModEntities;
import top.andro.not_enough_furniture.util.VoxelShapeHelper;

import java.util.List;
import java.util.Map;

public class WoodenChairBlock extends RotatedFurnitureBlock {
    private static final MapCodec<WoodenChairBlock> CODEC = RecordCodecBuilder.mapCodec(builder -> {
        return builder.group(WoodType.CODEC.fieldOf("wood_type").forGetter(block -> {
            return block.type;
        }), propertiesCodec()).apply(builder, WoodenChairBlock::new);
    });

    private final WoodType type;

    public WoodenChairBlock(WoodType type, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        this.type = type;
    }

    public WoodType getWoodType() {
        return this.type;
    }

    @Override
    protected MapCodec<WoodenChairBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        VoxelShape SHAPE_SEAT = Block.box(2, 8, 2, 14, 10, 14);
        VoxelShape SHAPE_BACK_LEFT_LEG = Block.box(2, 0, 2, 4, 8, 4);
        VoxelShape SHAPE_BACK_RIGHT_LEG = Block.box(12, 0, 2, 14, 8, 4);
        VoxelShape SHAPE_FRONT_LEFT_LEG = Block.box(2, 0, 12, 4, 8, 14);
        VoxelShape SHAPE_FRONT_RIGHT_LEG = Block.box(12, 0 ,12, 14, 8, 14);
        VoxelShape SHAPE_BACKREST = Block.box(12, 10, 2, 14, 22, 14);
        VoxelShape chairShape = VoxelShapeHelper.combine(List.of(SHAPE_SEAT, SHAPE_BACK_LEFT_LEG, SHAPE_BACK_RIGHT_LEG,
                SHAPE_FRONT_LEFT_LEG, SHAPE_FRONT_RIGHT_LEG, SHAPE_BACKREST));
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            VoxelShape rotatedChairShape = VoxelShapeHelper.rotateHorizontally(chairShape, direction);
            builder.put(state, rotatedChairShape);
        }
        return builder.build();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<SeatEntity> entities = level.getEntities(ModEntities.SEAT.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.SEAT.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }

    /*public List<TagKey<Block>> getTags()
    {
        return List.of(BlockTags.MINEABLE_WITH_AXE);
    }*/
}

