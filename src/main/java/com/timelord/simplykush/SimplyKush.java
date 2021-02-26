package com.timelord.simplykush;

import com.timelord.simplykush.registry.*;
import com.timelord.simplykush.registry.block.PreparationDeskCrafterBlock;
import com.timelord.simplykush.registry.recipes.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class SimplyKush implements ModInitializer {
	
	public static final String MOD_ID = "simplykush";
	
	public static final PreparationDeskCrafterBlock PREPARATION_DESK_CRAFTER_BLOCK = new PreparationDeskCrafterBlock(FabricBlockSettings.of(Material.METAL));
	
	public static final ItemGroup SIMPLY_KUSH = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.INDICA)
	);
	
/*	public static final ItemGroup TEST = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "test"))
			.icon(() -> new ItemStack(Blocks.ENCHANTING_TABLE))
			.appendItems(itemStacks -> {
				itemStacks.add(new ItemStack(ModBlocks.CLAY_POT));
				itemStacks.add(new ItemStack(ModItems.SATIVA));
				itemStacks.add( ItemStack(ModItems.INDICA));
			})
			.build();*/
	
	@Override
	public void onInitialize () {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModStats.registerStats();
		
		Registry.register(Registry.RECIPE_SERIALIZER, PreparationDeskRecipeSerializer.ID, PreparationDeskRecipeSerializer.INSTANCE);
		Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, PreparationDeskRecipe.Type.ID), PreparationDeskRecipe.Type.INSTANCE);
	}
}
