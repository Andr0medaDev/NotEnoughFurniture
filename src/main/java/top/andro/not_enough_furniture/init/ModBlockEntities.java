package top.andro.not_enough_furniture.init;

import top.andro.not_enough_furniture.Reference;
//import top.andro.not_enough_furniture.blockentity.DrawerBlockEntity;
import top.andro.not_enough_furniture.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);

    /*public static final Supplier<BlockEntityType<DrawerBlockEntity>> DRAWER =
            BLOCK_ENTITIES.register("drawer",
                    () -> BlockEntityType.Builder.of(DrawerBlockEntity::new,
                            ModBlocks.OAK_DRAWER.get(),
                            ModBlocks.SPRUCE_DRAWER.get(),
                            ModBlocks.BIRCH_DRAWER.get(),
                            ModBlocks.JUNGLE_DRAWER.get(),
                            ModBlocks.ACACIA_DRAWER.get(),
                            ModBlocks.DARK_OAK_DRAWER.get(),
                            ModBlocks.MANGROVE_DRAWER.get(),
                            ModBlocks.CHERRY_DRAWER.get(),
                            ModBlocks.CRIMSON_DRAWER.get(),
                            ModBlocks.WARPED_DRAWER.get()
                    ).build(null)
            );*/


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}