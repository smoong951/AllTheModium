package com.thevortex.allthemodium.worldgen.structures;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.lwjgl.system.CallbackI;

public class ATMConfiguredStructures {
   public static ConfiguredStructureFeature<?, ?> CONFIGURED_DUNGEON = ATMStructures.DUNGEON.get().configured(new JigsawConfiguration(() -> {
       return DungeonPieces.START;
   },6));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_PYRAMID = ATMStructures.PYRAMID.get().configured(new JigsawConfiguration(() ->{
        return PyramidPieces.START;
    },6));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_VILLAGE = ATMStructures.VILLAGE.get().configured(new JigsawConfiguration(() -> {
        return VillagePieces.START;
    },6));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "configured_dungeon"), CONFIGURED_DUNGEON);
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "configured_ancient_pyramid"), CONFIGURED_PYRAMID);
        Registry.register(registry, new ResourceLocation(Reference.MOD_ID, "configured_piglin_village"), CONFIGURED_VILLAGE);
    }
}