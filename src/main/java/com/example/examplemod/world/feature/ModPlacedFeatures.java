package com.example.examplemod.world.feature;

import com.example.examplemod.*;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ExampleMod.MODID);


    public static final RegistryObject<PlacedFeature> CREEPER_ORE_PLACED = PLACED_FEATURES.register("creeper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CREEPER_ORE.getHolder().get(),
                    commonOrePlacement(7, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> DEEPSLATE_CREEPER_ORE_PLACED = PLACED_FEATURES.register("deepslate_creeper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DEEPSLATE_CREEPER_ORE.getHolder().get(),
                    commonOrePlacement(12, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<PlacedFeature> NETHER_CREEPER_ORE_PLACED = PLACED_FEATURES.register("nether_creeper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_CREEPER_ORE.getHolder().get(),
                    commonOrePlacement(4, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(80)))));
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
    public static final RegistryObject<PlacedFeature> RED_MAPLE_CHECKED = PLACED_FEATURES.register("red_maple_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.RED_MAPLE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ExampleMod.RED_MAPLE_SAPLING.get()))));
    public static final RegistryObject<PlacedFeature> RED_MAPLE_PLACED = PLACED_FEATURES.register("red_maple_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RED_MAPLE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));
    
    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
