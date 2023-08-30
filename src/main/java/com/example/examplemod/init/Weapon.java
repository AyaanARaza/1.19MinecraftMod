package com.example.examplemod.init;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class Weapon {
	public static final CreativeModeTab MOD_ITEM_GROUP = new Sword(ExampleMod.MODID, () -> new ItemStack(Items.WOODEN_SWORD));
	public static class Sword extends CreativeModeTab{

		private final Supplier<ItemStack> iconsup;

		public Sword(final String label,final Supplier<ItemStack> iconsup) {
			super(label);
			this.iconsup = iconsup;
			
		}

		@Override
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return iconsup.get();
		}
		
	}
}
