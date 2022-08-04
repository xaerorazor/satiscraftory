
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.item.SSDItem;
import net.satiscraftory.item.NodeInvestigatorItem;
import net.satiscraftory.item.NodeFinderItem;
import net.satiscraftory.item.MachineWrenchItem;
import net.satiscraftory.SatiscraftoryMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class SatiscraftoryModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SatiscraftoryMod.MODID);
	public static final RegistryObject<Item> NODE_BASE = block(SatiscraftoryModBlocks.NODE_BASE, SatiscraftoryModTabs.TAB_SATISCRAFTORY);
	public static final RegistryObject<Item> NODE_FORGE = block(SatiscraftoryModBlocks.NODE_FORGE, SatiscraftoryModTabs.TAB_SATISCRAFTORY);
	public static final RegistryObject<Item> NODE_CREATIVE = block(SatiscraftoryModBlocks.NODE_CREATIVE, SatiscraftoryModTabs.TAB_SATISCRAFTORY);
	public static final RegistryObject<Item> NODE_MINER = block(SatiscraftoryModBlocks.NODE_MINER, SatiscraftoryModTabs.TAB_SATISCRAFTORY);
	public static final RegistryObject<Item> NODE_FINDER = REGISTRY.register("node_finder", () -> new NodeFinderItem());
	public static final RegistryObject<Item> NODE_INVESTIGATOR = REGISTRY.register("node_investigator", () -> new NodeInvestigatorItem());
	public static final RegistryObject<Item> MACHINE_WRENCH = REGISTRY.register("machine_wrench", () -> new MachineWrenchItem());
	public static final RegistryObject<Item> SSD = REGISTRY.register("ssd", () -> new SSDItem());
	public static final RegistryObject<Item> COAL_GENERATOR = block(SatiscraftoryModBlocks.COAL_GENERATOR, SatiscraftoryModTabs.TAB_SATISCRAFTORY);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
