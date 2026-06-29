package top.andro.not_enough_furniture.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.andro.not_enough_furniture.NotEnoughFurniture;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NotEnoughFurniture.MOD_ID);

    public static final Supplier<CreativeModeTab> NOT_ENOUGH_FURNITURE_TAB = CREATIVE_MODE_TAB.register("not_enough_furniture",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.OAK_CHAIR.get()))
                    .title(Component.translatable("creativetab.not_enough_furniture.not_enough_furniture"))
                    .displayItems((itemDisplayParameters, output) -> {
                    //output.accept(ModBlocks.MRCRAYFISH_PLUSH);

                    output.accept(ModBlocks.OAK_CHAIR);
                    output.accept(ModBlocks.SPRUCE_CHAIR);
                    output.accept(ModBlocks.BIRCH_CHAIR);
                    output.accept(ModBlocks.JUNGLE_CHAIR);
                    output.accept(ModBlocks.ACACIA_CHAIR);
                    output.accept(ModBlocks.DARK_OAK_CHAIR);
                    output.accept(ModBlocks.MANGROVE_CHAIR);
                    output.accept(ModBlocks.CHERRY_CHAIR);
                    output.accept(ModBlocks.CRIMSON_CHAIR);
                    output.accept(ModBlocks.WARPED_CHAIR);

                    output.accept(ModBlocks.OAK_TABLE);
                    output.accept(ModBlocks.SPRUCE_TABLE);
                    output.accept(ModBlocks.BIRCH_TABLE);
                    output.accept(ModBlocks.JUNGLE_TABLE);
                    output.accept(ModBlocks.ACACIA_TABLE);
                    output.accept(ModBlocks.DARK_OAK_TABLE);
                    output.accept(ModBlocks.MANGROVE_TABLE);
                    output.accept(ModBlocks.CHERRY_TABLE);
                    output.accept(ModBlocks.CRIMSON_TABLE);
                    output.accept(ModBlocks.WARPED_TABLE);

                    output.accept(ModBlocks.OAK_DESK);
                    output.accept(ModBlocks.SPRUCE_DESK);
                    output.accept(ModBlocks.BIRCH_DESK);
                    output.accept(ModBlocks.JUNGLE_DESK);
                    output.accept(ModBlocks.ACACIA_DESK);
                    output.accept(ModBlocks.DARK_OAK_DESK);
                    output.accept(ModBlocks.MANGROVE_DESK);
                    output.accept(ModBlocks.CHERRY_DESK);
                    output.accept(ModBlocks.CRIMSON_DESK);
                    output.accept(ModBlocks.WARPED_DESK);

                    output.accept(ModBlocks.WHITE_COUCH);
                    output.accept(ModBlocks.LIGHT_GRAY_COUCH);
                    output.accept(ModBlocks.GRAY_COUCH);
                    output.accept(ModBlocks.BLACK_COUCH);
                    output.accept(ModBlocks.BROWN_COUCH);
                    output.accept(ModBlocks.RED_COUCH);
                    output.accept(ModBlocks.ORANGE_COUCH);
                    output.accept(ModBlocks.YELLOW_COUCH);
                    output.accept(ModBlocks.LIME_COUCH);
                    output.accept(ModBlocks.GREEN_COUCH);
                    output.accept(ModBlocks.CYAN_COUCH);
                    output.accept(ModBlocks.LIGHT_BLUE_COUCH);
                    output.accept(ModBlocks.BLUE_COUCH);
                    output.accept(ModBlocks.PURPLE_COUCH);
                    output.accept(ModBlocks.MAGENTA_COUCH);
                    output.accept(ModBlocks.PINK_COUCH);
                    })
                    .build());
    
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
