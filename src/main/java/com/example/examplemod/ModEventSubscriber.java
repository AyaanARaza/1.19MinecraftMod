package com.example.examplemod;

import com.example.examplemod.init.Misc;
import com.example.examplemod.init.Swords;
import com.example.examplemod.init.Weapon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ExampleMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {
	@SubscribeEvent
	public static void onRegisterItems(RegisterEvent event) {
	}
	//public static void onRegisterBlocks(RegisterEvent event) {
		//event.register(ForgeRegistries.Keys.BLOCKS, helper -> {helper.register( new ResourceLocation(ExampleMod.MODID, "creeper_ore"), new Block(Properties.of(Material.STONE)));});
	//}
	
}
// I don't remember asking