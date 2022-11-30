package com.hyperdash.firmaciv.util;

import com.hyperdash.firmaciv.Firmaciv;
import net.dries007.tfc.util.Helpers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

import static net.dries007.tfc.util.Helpers.identifier;

public class FirmacivTags {


    public static class Blocks {

        public static final TagKey<Block> CAN_MAKE_CANOE = create("can_make_canoe");

        /*
        private static TagKey<Block> create(String id) {
            return TagKey.create(Registry.BLOCK_REGISTRY, identifier(id));
        }
        */
        public static TagKey<Block> create(ResourceLocation name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, name);
        }

        public static TagKey<Block> create(String id) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("firmaciv","can_make_canoe"));
        }

        public Blocks() {
        }

    }

    public static class Items {

    }


}
