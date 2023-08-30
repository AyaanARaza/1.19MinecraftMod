package com.example.examplemod;

import com.example.examplemod.EmptyTank;
import com.example.examplemod.block.custom.AlchemyTable;
import com.example.examplemod.block.custom.BlueberryCropBlock;
import com.example.examplemod.block.custom.Crate;
import com.example.examplemod.block.custom.ModBlockEntities;
import com.example.examplemod.block.custom.ModFlammableRotatedPillarBlock;
import com.example.examplemod.effect.ModEffects;
import com.example.examplemod.enchantment.ModEnchantments;
import com.example.examplemod.init.Interactable;
import com.example.examplemod.init.Swords;
import com.example.examplemod.potion.ModPotions;
import com.example.examplemod.screen.AlchemyTableScreen;
import com.example.examplemod.screen.CrateScreen;
import com.example.examplemod.screen.ModMenuTypes;
import com.example.examplemod.sound.ModSounds;
import com.example.examplemod.world.feature.ModConfiguredFeatures;
import com.example.examplemod.world.feature.ModPlacedFeatures;
import com.example.examplemod.world.feature.tree.RedMapleTreeGrower;
import com.example.examplemod.world.village.VillageAddition;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import com.example.examplemod.util.BetterBrewingRecipe;
import com.example.examplemod.villager.ModVillagers;

import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod
{
  
    // Define mod id in a common place for everything to reference
    public static final String MODID = "sword";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String VERSION = "1.19";
    public static Item mySword;
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    
    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    
    public static final RegistryObject<Block> creeper_ore = BLOCKS.register("creeper_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> creeper_ore_item = ITEMS.register("creeper_ore", () -> new BlockItem(creeper_ore.get(), new Item.Properties().tab(Swords.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> deepslate_creeper_ore = BLOCKS.register("deepslate_creeper_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> deepslate_creeper_ore_item = ITEMS.register("deepslate_creeper_ore", () -> new BlockItem(deepslate_creeper_ore.get(), new Item.Properties().tab(Swords.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> nether_creeper_ore = BLOCKS.register("nether_creeper_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(14f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> nether_creeper_ore_item = ITEMS.register("nether_creeper_ore", () -> new BlockItem(nether_creeper_ore.get(), new Item.Properties().tab(Swords.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> bluestone_block = BLOCKS.register("bluestone_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> bluestone_block_item = ITEMS.register("bluestone_block", () -> new BlockItem(bluestone_block.get(), new Item.Properties().tab(Swords.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> empty_tank = BLOCKS.register("empty_tank", () -> new EmptyTank(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion().strength(6f)));
    public static final RegistryObject<Item> empty_tank_item = ITEMS.register("empty_tank", () -> new BlockItem(empty_tank.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> alchemy_table = BLOCKS.register("alchemy_table", () -> new AlchemyTable(BlockBehaviour.Properties.of(Material.WOOD).strength(3f)));
    public static final RegistryObject<Item> alchemy_table_item = ITEMS.register("alchemy_table", () -> new BlockItem(alchemy_table.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> RED_MAPLE_LOG = BLOCKS.register("red_maple_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Item> RED_MAPLE_LOG_ITEM = ITEMS.register("red_maple_log", () -> new BlockItem(RED_MAPLE_LOG.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> RED_MAPLE_WOOD = BLOCKS.register("red_maple_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Item> RED_MAPLE_WOOD_ITEM = ITEMS.register("red_maple_wood", () -> new BlockItem(RED_MAPLE_WOOD.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> STRIPPED_RED_MAPLE_LOG = BLOCKS.register("stripped_red_maple_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Item> STRIPPED_RED_MAPLE_LOG_ITEM = ITEMS.register("stripped_red_maple_log", () -> new BlockItem(STRIPPED_RED_MAPLE_LOG.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> STRIPPED_RED_MAPLE_WOOD = BLOCKS.register("stripped_red_maple_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Item> STRIPPED_RED_MAPLE_WOOD_ITEM = ITEMS.register("stripped_red_maple_wood", () -> new BlockItem(STRIPPED_RED_MAPLE_WOOD.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> RED_MAPLE_PLANKS = BLOCKS.register("red_maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Item> RED_MAPLE_PLANKS_ITEM = ITEMS.register("red_maple_planks", () -> new BlockItem(RED_MAPLE_PLANKS.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> RED_MAPLE_LEAVES = BLOCKS.register("red_maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });
    public static final RegistryObject<Item> RED_MAPLE_LEAVES_ITEMS = ITEMS.register("red_maple_leaves", () -> new BlockItem(RED_MAPLE_LEAVES.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> RED_MAPLE_SAPLING = BLOCKS.register("red_maple_sapling", () -> new SaplingBlock(new RedMapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Item> RED_MAPLE_SAPLING_ITEMS = ITEMS.register("red_maple_sapling", () -> new BlockItem(RED_MAPLE_SAPLING.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> crate = BLOCKS.register("crate", () -> new Crate(BlockBehaviour.Properties.of(Material.WOOD).strength(3f)));
    public static final RegistryObject<Item> crate_item = ITEMS.register("crate", () -> new BlockItem(crate.get(), new Item.Properties().tab(Interactable.MOD_ITEM_GROUP)));
    
    public ExampleMod()
    {	
    	LOGGER.debug("Hello");
    	LOGGER.debug("Hola por favor disfrutar");
    	LOGGER.debug("Bonjour");
    	LOGGER.debug("Salam");
    	LOGGER.debug("Konichuwa");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModSounds.register(modEventBus);
        ModVillagers.register(modEventBus);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        ItemBlockRenderTypes.setRenderLayer(empty_tank.get(), RenderType.translucent());
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.THICK,
                Items.CHORUS_FRUIT, ModPotions.TELEPORT_POTION.get()));
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
        
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SuppressWarnings("removal")
		@SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            MenuScreens.register(ModMenuTypes.Alchemy_Table_Menu.get(), AlchemyTableScreen::new);
            MenuScreens.register(ModMenuTypes.Crate_Menu.get(), CrateScreen::new);
            ItemBlockRenderTypes.setRenderLayer(BLUEBERRY_CROP.get(), RenderType.cutout());
        }
    }
    
}
