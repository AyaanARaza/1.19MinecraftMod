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
public class FireStaff extends SwordItem {
	public FireStaff(ModItemTier tier, int maxDamage, int attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	 }
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5));
		return super.hurtEnemy(stack, target, attacker);
	}
}