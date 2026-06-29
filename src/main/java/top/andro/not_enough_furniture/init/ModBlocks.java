package top.andro.not_enough_furniture.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.andro.not_enough_furniture.Reference;
//import top.andro.not_enough_furniture.block.DrawerBlock;
import top.andro.not_enough_furniture.block.*;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Reference.MOD_ID);

    //public static final DeferredBlock<Block> MRCRAYFISH_PLUSH = registerBlock("mrcrayfish_plush",  () -> new PlushBlock(BlockBehaviour.Properties.ofFullCopy(RED_WOOL).noOcclusion()));


    public static final DeferredBlock<Block> OAK_CHAIR = registerBlock("oak_chair",  () -> new WoodenChairBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_CHAIR = registerBlock("spruce_chair",  () -> new WoodenChairBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(SPRUCE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_CHAIR = registerBlock("birch_chair",  () -> new WoodenChairBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(BIRCH_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_CHAIR = registerBlock("jungle_chair",  () -> new WoodenChairBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(JUNGLE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_CHAIR = registerBlock("acacia_chair",  () -> new WoodenChairBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_CHAIR = registerBlock("dark_oak_chair",  () -> new WoodenChairBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(DARK_OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_CHAIR = registerBlock("mangrove_chair",  () -> new WoodenChairBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(MANGROVE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_CHAIR = registerBlock("cherry_chair",  () -> new WoodenChairBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_CHAIR = registerBlock("crimson_chair",  () -> new WoodenChairBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> WARPED_CHAIR = registerBlock("warped_chair",  () -> new WoodenChairBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(WARPED_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));

    public static final DeferredBlock<Block> OAK_TABLE = registerBlock("oak_table",  () -> new WoodenTableBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_TABLE = registerBlock("spruce_table",  () -> new WoodenTableBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(SPRUCE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_TABLE = registerBlock("birch_table",  () -> new WoodenTableBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(BIRCH_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_TABLE = registerBlock("jungle_table",  () -> new WoodenTableBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(JUNGLE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_TABLE = registerBlock("acacia_table",  () -> new WoodenTableBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",  () -> new WoodenTableBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(DARK_OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_TABLE = registerBlock("mangrove_table",  () -> new WoodenTableBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(MANGROVE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_TABLE = registerBlock("cherry_table",  () -> new WoodenTableBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_TABLE = registerBlock("crimson_table",  () -> new WoodenTableBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    public static final DeferredBlock<Block> WARPED_TABLE = registerBlock("warped_table",  () -> new WoodenTableBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(WARPED_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));

    public static final DeferredBlock<Block> OAK_DESK = registerBlock("oak_desk",  () -> new DeskBlock(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(Blocks.OAK_PLANKS.defaultMapColor()).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> SPRUCE_DESK = registerBlock("spruce_desk",  () -> new DeskBlock(WoodType.SPRUCE, BlockBehaviour.Properties.ofFullCopy(SPRUCE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> BIRCH_DESK = registerBlock("birch_desk",  () -> new DeskBlock(WoodType.BIRCH, BlockBehaviour.Properties.ofFullCopy(BIRCH_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> JUNGLE_DESK = registerBlock("jungle_desk",  () -> new DeskBlock(WoodType.JUNGLE, BlockBehaviour.Properties.ofFullCopy(JUNGLE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> ACACIA_DESK = registerBlock("acacia_desk",  () -> new DeskBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(ACACIA_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> DARK_OAK_DESK = registerBlock("dark_oak_desk",  () -> new DeskBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.ofFullCopy(DARK_OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> MANGROVE_DESK = registerBlock("mangrove_desk",  () -> new DeskBlock(WoodType.MANGROVE, BlockBehaviour.Properties.ofFullCopy(MANGROVE_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> CHERRY_DESK = registerBlock("cherry_desk",  () -> new DeskBlock(WoodType.CHERRY, BlockBehaviour.Properties.ofFullCopy(CHERRY_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> CRIMSON_DESK = registerBlock("crimson_desk",  () -> new DeskBlock(WoodType.CRIMSON, BlockBehaviour.Properties.ofFullCopy(CRIMSON_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));
    public static final DeferredBlock<Block> WARPED_DESK = registerBlock("warped_desk",  () -> new DeskBlock(WoodType.WARPED, BlockBehaviour.Properties.ofFullCopy(WARPED_PLANKS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn()));

    public static final DeferredBlock<Block> WHITE_COUCH = registerBlock("white_couch", () -> new CouchBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_GRAY_COUCH = registerBlock("light_gray_couch", () -> new CouchBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> GRAY_COUCH = registerBlock("gray_couch", () -> new CouchBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_COUCH = registerBlock("black_couch", () -> new CouchBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> BROWN_COUCH = registerBlock("brown_couch", () -> new CouchBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> RED_COUCH = registerBlock("red_couch", () -> new CouchBlock(DyeColor.RED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_COUCH = registerBlock("orange_couch", () -> new CouchBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> YELLOW_COUCH = registerBlock("yellow_couch", () -> new CouchBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> LIME_COUCH = registerBlock("lime_couch", () -> new CouchBlock(DyeColor.LIME, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> GREEN_COUCH = registerBlock("green_couch", () -> new CouchBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_COUCH = registerBlock("cyan_couch", () -> new CouchBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_COUCH = registerBlock("light_blue_couch", () -> new CouchBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> BLUE_COUCH = registerBlock("blue_couch", () -> new CouchBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> PURPLE_COUCH = registerBlock("purple_couch", () -> new CouchBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> MAGENTA_COUCH = registerBlock("magenta_couch", () -> new CouchBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));
    public static final DeferredBlock<Block> PINK_COUCH = registerBlock("pink_couch", () -> new CouchBlock(DyeColor.PINK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F).sound(SoundType.WOOL).noOcclusion()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
