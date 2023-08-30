package com.example.examplemod.potion;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
	public static final DeferredRegister<Potion> POTIONS
    	= DeferredRegister.create(ForgeRegistries.POTIONS, ExampleMod.MODID);

	public static final RegistryObject<Potion> TELEPORT_POTION = POTIONS.register("teleport_potion",
			() -> new Potion(new MobEffectInstance(ModEffects.TELEPORT.get(), 0, 0)));

	public static void register(IEventBus eventBus) {
		POTIONS.register(eventBus);
}
}
