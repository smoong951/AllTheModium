package com.thevortex.allthemodium.material;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.thevortex.allthemodium.init.ModItems;

import javax.swing.*;

public enum AArmorMaterial implements ArmorMaterial {
	   ALLTHEMODIUM("allthemodium", 500, new int[]{100, 100, 200, 100}, 185, SoundEvents.ARMOR_EQUIP_CHAIN, 125.0F, () -> {
		      return Ingredient.of(ModItems.ALLTHEMODIUM_INGOT);
		   }),
	   VIBRANIUM("vibranium", 1000, new int[]{150, 300, 400, 150}, 235, SoundEvents.ARMOR_EQUIP_CHAIN, 250.0F, () -> {
	      return Ingredient.of(ModItems.VIBRANIUM_INGOT);
	   }),
	   UNOBTAINIUM("unobtainium",2000, new int[]{400, 600, 600, 400}, 285, SoundEvents.ARMOR_EQUIP_CHAIN, 500.0F, () -> {
	      return Ingredient.of(ModItems.UNOBTAINIUM_INGOT);
	   });
    

   private static final int[] MAX_DAMAGE_ARRAY = new int[]{400, 600, 600, 400};
   private final String name;
   
   private final int maxDamageFactor;
   private final int[] damageReductionAmountArray;
   private final int enchantability;
   private final SoundEvent soundEvent;
   private final float toughness;
   private final float knockback;
   private final LazyLoadedValue<Ingredient> repairMaterial;

   AArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
      this.name = nameIn;
      this.maxDamageFactor = maxDamageFactorIn;
      this.damageReductionAmountArray = damageReductionAmountsIn;
      this.enchantability = enchantabilityIn;
      this.soundEvent = equipSoundIn;
      this.toughness = p_i48533_8_;
      this.repairMaterial = new LazyLoadedValue(repairMaterialSupplier);
      this.knockback = this.toughness/100;
   }
   @Override
   public int getDurabilityForSlot(EquipmentSlot slotIn) { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }
   @Override
   public int getDefenseForSlot(EquipmentSlot slotIn) { return this.damageReductionAmountArray[slotIn.getIndex()];  }
   @Override
   public int getEnchantmentValue() {
      return this.enchantability;
   }
   @Override
   public SoundEvent getEquipSound() {
      return this.soundEvent;
   }
   @Override
   public Ingredient getRepairIngredient() {
      return this.repairMaterial.get();
   }
   @OnlyIn(Dist.CLIENT)
   public String getName() {
      return this.name;
   }
   @Override
   public float getToughness() {
      return this.toughness;
   }
   @Override
   public float getKnockbackResistance() { return this.knockback;   }

}