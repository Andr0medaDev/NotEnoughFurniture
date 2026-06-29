package top.andro.not_enough_furniture.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import top.andro.not_enough_furniture.init.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //this.dropSelf(ModBlocks.MRCRAYFISH_PLUSH.get());

        this.dropSelf(ModBlocks.OAK_CHAIR.get());
        this.dropSelf(ModBlocks.SPRUCE_CHAIR.get());
        this.dropSelf(ModBlocks.BIRCH_CHAIR.get());
        this.dropSelf(ModBlocks.JUNGLE_CHAIR.get());
        this.dropSelf(ModBlocks.ACACIA_CHAIR.get());
        this.dropSelf(ModBlocks.DARK_OAK_CHAIR.get());
        this.dropSelf(ModBlocks.MANGROVE_CHAIR.get());
        this.dropSelf(ModBlocks.CHERRY_CHAIR.get());
        this.dropSelf(ModBlocks.CRIMSON_CHAIR.get());
        this.dropSelf(ModBlocks.WARPED_CHAIR.get());

        this.dropSelf(ModBlocks.OAK_TABLE.get());
        this.dropSelf(ModBlocks.SPRUCE_TABLE.get());
        this.dropSelf(ModBlocks.BIRCH_TABLE.get());
        this.dropSelf(ModBlocks.JUNGLE_TABLE.get());
        this.dropSelf(ModBlocks.ACACIA_TABLE.get());
        this.dropSelf(ModBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(ModBlocks.MANGROVE_TABLE.get());
        this.dropSelf(ModBlocks.CHERRY_TABLE.get());
        this.dropSelf(ModBlocks.CRIMSON_TABLE.get());
        this.dropSelf(ModBlocks.WARPED_TABLE.get());

        this.dropSelf(ModBlocks.OAK_DESK.get());
        this.dropSelf(ModBlocks.SPRUCE_DESK.get());
        this.dropSelf(ModBlocks.BIRCH_DESK.get());
        this.dropSelf(ModBlocks.JUNGLE_DESK.get());
        this.dropSelf(ModBlocks.ACACIA_DESK.get());
        this.dropSelf(ModBlocks.DARK_OAK_DESK.get());
        this.dropSelf(ModBlocks.MANGROVE_DESK.get());
        this.dropSelf(ModBlocks.CHERRY_DESK.get());
        this.dropSelf(ModBlocks.CRIMSON_DESK.get());
        this.dropSelf(ModBlocks.WARPED_DESK.get());

        this.dropSelf(ModBlocks.WHITE_COUCH.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_COUCH.get());
        this.dropSelf(ModBlocks.GRAY_COUCH.get());
        this.dropSelf(ModBlocks.BLACK_COUCH.get());
        this.dropSelf(ModBlocks.BROWN_COUCH.get());
        this.dropSelf(ModBlocks.RED_COUCH.get());
        this.dropSelf(ModBlocks.ORANGE_COUCH.get());
        this.dropSelf(ModBlocks.YELLOW_COUCH.get());
        this.dropSelf(ModBlocks.LIME_COUCH.get());
        this.dropSelf(ModBlocks.GREEN_COUCH.get());
        this.dropSelf(ModBlocks.CYAN_COUCH.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_COUCH.get());
        this.dropSelf(ModBlocks.BLUE_COUCH.get());
        this.dropSelf(ModBlocks.PURPLE_COUCH.get());
        this.dropSelf(ModBlocks.MAGENTA_COUCH.get());
        this.dropSelf(ModBlocks.PINK_COUCH.get());
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
