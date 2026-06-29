package top.andro.not_enough_furniture;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import org.slf4j.Logger;
import top.andro.not_enough_furniture.entity.CouchSeatEntity;
import top.andro.not_enough_furniture.entity.CouchSeatRenderer;
import top.andro.not_enough_furniture.entity.SeatRenderer;
import top.andro.not_enough_furniture.init.ModBlocks;
import top.andro.not_enough_furniture.init.ModCreativeModeTabs;
import top.andro.not_enough_furniture.init.ModEntities;
import top.andro.not_enough_furniture.init.ModItems;

import java.util.List;
//

@Mod(NotEnoughFurniture.MOD_ID)
public class NotEnoughFurniture {
    public static final String MOD_ID = "not_enough_furniture";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NotEnoughFurniture(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OAK_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPRUCE_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIRCH_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.JUNGLE_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ACACIA_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARK_OAK_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MANGROVE_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRIMSON_CHAIR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WARPED_CHAIR.get(), RenderType.translucent());


            EntityRenderers.register(ModEntities.SEAT.get(), SeatRenderer::new);
            EntityRenderers.register(ModEntities.COUCH_SEAT.get(), CouchSeatRenderer::new);

            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
