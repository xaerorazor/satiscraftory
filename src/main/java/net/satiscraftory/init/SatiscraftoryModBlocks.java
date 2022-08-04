
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.block.VABlock;
import net.satiscraftory.block.NodeMinerBlock;
import net.satiscraftory.block.NodeForgeBlock;
import net.satiscraftory.block.NodeCreativeBlock;
import net.satiscraftory.block.NodeBaseBlock;
import net.satiscraftory.block.CoalGeneratorBlock;
import net.satiscraftory.SatiscraftoryMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class SatiscraftoryModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SatiscraftoryMod.MODID);
	public static final RegistryObject<Block> NODE_BASE = REGISTRY.register("node_base", () -> new NodeBaseBlock());
	public static final RegistryObject<Block> NODE_FORGE = REGISTRY.register("node_forge", () -> new NodeForgeBlock());
	public static final RegistryObject<Block> NODE_CREATIVE = REGISTRY.register("node_creative", () -> new NodeCreativeBlock());
	public static final RegistryObject<Block> NODE_MINER = REGISTRY.register("node_miner", () -> new NodeMinerBlock());
	public static final RegistryObject<Block> COAL_GENERATOR = REGISTRY.register("coal_generator", () -> new CoalGeneratorBlock());
	public static final RegistryObject<Block> VA = REGISTRY.register("va", () -> new VABlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			CoalGeneratorBlock.registerRenderLayer();
		}
	}
}
