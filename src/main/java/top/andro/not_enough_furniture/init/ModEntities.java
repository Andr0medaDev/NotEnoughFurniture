package top.andro.not_enough_furniture.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.andro.not_enough_furniture.Reference;
import top.andro.not_enough_furniture.entity.CouchSeatEntity;
import top.andro.not_enough_furniture.entity.SeatEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Reference.MOD_ID);


    public static final Supplier<EntityType<SeatEntity>> SEAT =
            ENTITY_TYPES.register("seat", () -> EntityType.Builder.of(SeatEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("seat"));

    public static final Supplier<EntityType<CouchSeatEntity>> COUCH_SEAT =
            ENTITY_TYPES.register("couch_seat", () -> EntityType.Builder.of(CouchSeatEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("couch_seat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
