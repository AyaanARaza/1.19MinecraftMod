package com.example.examplemod.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import com.example.examplemod.*;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_KEY = registerKey("red_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_SPAWN_KEY = registerKey("red_maple_spawn");
	
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister
			.create(Registry.CONFIGURED_FEATURE_REGISTRY, ExampleMod.MODID);

	public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CREEPER_ORES = Suppliers
			.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
					ExampleMod.creeper_ore.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> CREEPER_ORE = CONFIGURED_FEATURES.register(
			"creeper_ore",
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_CREEPER_ORES.get(), 7)));
	
	public static final Supplier<List<OreConfiguration.TargetBlockState>> DEEPSLATE_CREEPER_ORES = Suppliers
			.memoize(() -> List.of(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ExampleMod.deepslate_creeper_ore.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> DEEPSLATE_CREEPER_ORE = CONFIGURED_FEATURES.register(
			"deepslate_creeper_ore",
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DEEPSLATE_CREEPER_ORES.get(), 7)));
	
	public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_CREEPER_ORES = Suppliers
			.memoize(() -> List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,
					ExampleMod.nether_creeper_ore.get().defaultBlockState())));

	public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_CREEPER_ORE = CONFIGURED_FEATURES.register(
			"nether_creeper_ore",
			() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_CREEPER_ORES.get(), 5)));
	 public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE =
	            CONFIGURED_FEATURES.register("red_maple", () ->
	                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
	                            BlockStateProvider.simple(ExampleMod.RED_MAPLE_LOG.get()),
	                            new StraightTrunkPlacer(5, 6, 3),
	                            BlockStateProvider.simple(ExampleMod.RED_MAPLE_LEAVES.get()),
	                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
	                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_MAPLE_SPAWN =
            CONFIGURED_FEATURES.register("red_maple_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.RED_MAPLE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.RED_MAPLE_CHECKED.getHolder().get())));

	public static void register(IEventBus eventBus) {
		CONFIGURED_FEATURES.register(eventBus);
	}
	 public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
	        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new ResourceLocation(ExampleMod.MODID, name));
	    }	
}
