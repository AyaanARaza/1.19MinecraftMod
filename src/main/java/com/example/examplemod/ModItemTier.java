package com.example.examplemod;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModItemTier implements Tier {
	
	private int harvestLevel;
	private int maxUses;
	private float efficiency;
	private float attackDamage;
	private int enchantability;
	private LazyLoadedValue<Ingredient> repairMaterial;

	@SuppressWarnings("deprecation")
	ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
    this.harvestLevel = harvestLevel;
    this.maxUses = maxUses;
    this.efficiency = efficiency;
    this.attackDamage = attackDamage;
    this.enchantability = enchantability;
    this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
}
	
	@Override
	public int getUses() {
		// TODO Auto-generated method stub
		return maxUses;
	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		// TODO Auto-generated method stub
		return attackDamage;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return harvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		// TODO Auto-generated method stub
		return enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return repairMaterial.get();
	}

}
