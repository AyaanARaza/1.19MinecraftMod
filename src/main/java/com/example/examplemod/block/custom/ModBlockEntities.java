package com.example.examplemod.block.custom;

import com.example.examplemod.ExampleMod;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MODID);

    public static final RegistryObject<BlockEntityType<AlchemyTableBlockEntity>> alchemy_table =
            BLOCK_ENTITIES.register("alchemy_table", () ->
                    BlockEntityType.Builder.of(AlchemyTableBlockEntity::new,
                            ExampleMod.alchemy_table.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<CrateBlockEntity>> crate =
            BLOCK_ENTITIES.register("crate", () ->
            BlockEntityType.Builder.of(CrateBlockEntity::new,
                    ExampleMod.crate.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}