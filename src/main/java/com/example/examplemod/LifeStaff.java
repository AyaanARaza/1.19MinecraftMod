package com.example.examplemod;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.effect.*;
import net.minecraft.world.item.alchemy.Potions;
import java.util.Random;
import java.util.ArrayList;
public class LifeStaff extends SwordItem {
	public LifeStaff(ModItemTier tier, int maxDamage, int attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	 }
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addEffect(new MobEffectInstance(MobEffects.HARM, 1));
		target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));
		attacker.addEffect(new MobEffectInstance(MobEffects.HEAL, 1));
		attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10));
		return super.hurtEnemy(stack, target, attacker);
	}
}