package com.example.examplemod.enchantment;



import com.example.examplemod.ExampleMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ExampleMod.MODID);

    public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    () -> new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> BOOM =
            ENCHANTMENTS.register("boom",
                    () -> new BoomEnchantment(Enchantment.Rarity.RARE,
                            EnchantmentCategory.BOW, EquipmentSlot.MAINHAND));
    
    public static RegistryObject<Enchantment> NETHERWRATH =
            ENCHANTMENTS.register("netherwrath",
                    () -> new NetherWrathEnchantment(Enchantment.Rarity.RARE,
                    		EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}