package com.example.examplemod.effect;

import com.example.examplemod.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS
    = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ExampleMod.MODID);

	public static final RegistryObject<MobEffect> TELEPORT = MOB_EFFECTS.register("teleport",() -> new TeleportEffect(MobEffectCategory.NEUTRAL, 8985823	));

	public static void register(IEventBus eventBus) {
		MOB_EFFECTS.register(eventBus);
}
}
