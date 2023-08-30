package com.example.examplemod.enchantment;

import java.util.Random;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;



public class BoomEnchantment extends Enchantment {
	Random random = new Random();
    public BoomEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
    	
        if(!pAttacker.level.isClientSide()) {
            ServerLevel world = ((ServerLevel) pAttacker.level);
            BlockPos position = pTarget.blockPosition();
            
            if(pLevel == 1) {
            	int chance = random.nextInt(10);
            	if (chance == 5) {
	                EntityType.TNT.spawn(world, null, null, position,
	                        MobSpawnType.TRIGGERED, true, true);
	                pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));
            	}
                
            }

            if(pLevel == 2) {
            	int chance = random.nextInt(10);
            	if (chance<5 & chance % 2 ==0) {
	                EntityType.TNT.spawn(world, null, null, position,
	                        MobSpawnType.TRIGGERED, true, true);
	                EntityType.TNT.spawn(world, null, null, position,
	                        MobSpawnType.TRIGGERED, true, true);
	                pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));
            	}
            }
            if(pLevel == 3) {
            	int chance = random.nextInt(10);
            	if (chance<5) {
	                EntityType.TNT.spawn(world, null, null, position,
	                        MobSpawnType.TRIGGERED, true, true);
	                EntityType.TNT.spawn(world, null, null, position,
	                        MobSpawnType.TRIGGERED, true, true);
	                pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10));
            	}
            	}
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
    public boolean isTradeable() {
        return true;
     }

     public boolean isDiscoverable() {
        return true;
     }
}
