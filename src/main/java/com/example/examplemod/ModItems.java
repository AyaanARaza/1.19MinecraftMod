package com.example.examplemod;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.Misc;
import com.example.examplemod.init.Weapon;
import com.example.examplemod.sound.ModSounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	static ModItemTier wack_redstone = new ModItemTier(3, 10, 1f, 0f, 10, () -> {return Ingredient.of(Items.REDSTONE);});
	static ModItemTier copper = new ModItemTier(3, 150, 2f, 3f, 10, () -> {return Ingredient.of(Items.COPPER_INGOT);});
	static ModItemTier golden = new ModItemTier(3, 150, 2f, 3f, 10, () -> {return Ingredient.of(Items.RAW_GOLD);});
	static ModItemTier pickle = new ModItemTier(3, 150, 0f, 3f, 10, () -> {return Ingredient.of(Items.SEA_PICKLE);});
	static ModItemTier fire = new ModItemTier(3, 150, 4f, 3f, 10, () -> {return Ingredient.of(Items.FLINT_AND_STEEL);});
	static ModItemTier slotted = new ModItemTier(3, 150, 1f, 6f, 10, () -> {return Ingredient.of(Items.IRON_BARS);});
	static ModItemTier spider_eyes = new ModItemTier(0, 59, 2.0F, 0.0F, 15, () -> {return Ingredient.of(Items.SPIDER_EYE);});
	
	
	static ModItemTier redstone = new ModItemTier(3, 150, 4f, 7f, 10, () -> {return Ingredient.of(Items.REDSTONE);});
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> REDSTONE_SWORD = ITEMS.register("redstone_sword",
            () -> new SwordItem(redstone, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> BLUESTONE_DUST = ITEMS.register("bluestone_dust",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));

    static ModItemTier bluestone = new ModItemTier(3, 150, 1f, 6f, 10, () -> {return Ingredient.of(BLUESTONE_DUST.get());});
    
    public static final RegistryObject<Item> LIFE_STEAL = ITEMS.register("life_steal",
            () -> new LifeStaff(bluestone, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> POISON_NEEDLE = ITEMS.register("posion_needle",
            () -> new PoisonNeedle(spider_eyes, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(copper, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> PICKLE_SWORD = ITEMS.register("pickle_sword",
            () -> new SwordItem(pickle, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));   
    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword",
            () -> new SwordItem(fire, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> SLOTTED_SWORD = ITEMS.register("slotted_sword",
            () -> new SwordItem(slotted, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_SOUL_CRYSTAL = ITEMS.register("golden_soul_crystal",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> COLD_MAGMA_FUSION_SOLUTION = ITEMS.register("cold_magma_fusion_solution",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> MAGMA_FUSION_SOLUTION = ITEMS.register("magma_fusion_solution",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    
    static ModItemTier magma = new ModItemTier(3, 950, 4F, 7F, 15, () -> {return Ingredient.of(MAGMA_FUSION_SOLUTION.get());});
    public static final RegistryObject<Item> FIRE_STAFF = ITEMS.register("fire_staff",
            () -> new FireStaff(magma, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> RAW_CREEPER_ORE = ITEMS.register("raw_creeper_ore",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> CREEPER_INGOT = ITEMS.register("creeper_ingot",
            () -> new Item(new Item.Properties().tab(Misc.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_SOUL_STAFF = ITEMS.register("golden_soul_staff",
            () -> new Staff(golden, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> SOUL_SHARER = ITEMS.register("soul_sharer",
            () -> new HealStaff(wack_redstone, 0, 0, new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    
    
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ExampleMod.BLUEBERRY_CROP.get(),
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().tab(Weapon.MOD_ITEM_GROUP)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    
    public static final RegistryObject<Item> SOULLESS_MUSIC_DISC = ITEMS.register("soulless_music_disc",
            () -> new RecordItem(4, ModSounds.soulless,
                    new Item.Properties().tab(Weapon.MOD_ITEM_GROUP).stacksTo(1)));

    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}