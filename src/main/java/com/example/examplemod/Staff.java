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
public class Staff extends SwordItem {
	public Staff(ModItemTier tier, int maxDamage, int attackDamage, Properties properties) {
		super(tier, maxDamage, attackDamage, properties);
	 }
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Random random = new Random();
		attacker.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200));
		int number = random.nextInt(4);
		ArrayList<MobEffectInstance> effect = new ArrayList<MobEffectInstance>();
		effect.add(new MobEffectInstance(MobEffects.LEVITATION, 1200));
		effect.add(new MobEffectInstance(MobEffects.CONFUSION, 1200));
		effect.add(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200));
		effect.add(new MobEffectInstance(MobEffects.WEAKNESS, 1200));
		target.addEffect(effect.get(number));
		return super.hurtEnemy(stack, target, attacker);
	}
}