package com.example.examplemod.effect;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import java.util.Random;

public class TeleportEffect extends InstantenousMobEffect{

	public TeleportEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
        	Random rand = new Random();
            Double x = pLivingEntity.getX()+rand.nextInt(-10, 10);
            Double y = pLivingEntity.getY()+rand.nextInt(-10, 10);;
            Double z = pLivingEntity.getZ()+rand.nextInt(-10, 10);;
            
            

            pLivingEntity.teleportTo(x, y, z);
            pLivingEntity.setDeltaMovement(0, 0, 0);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
	
}
