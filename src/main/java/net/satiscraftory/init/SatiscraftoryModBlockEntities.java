
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.block.entity.NodeForgeBlockEntity;
import net.satiscraftory.block.entity.NodeCreativeBlockEntity;
import net.satiscraftory.block.entity.NodeBaseBlockEntity;
import net.satiscraftory.block.entity.CoalGeneratorBlockEntity;
import net.satiscraftory.SatiscraftoryMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class SatiscraftoryModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			SatiscraftoryMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> NODE_BASE = register("node_base", SatiscraftoryModBlocks.NODE_BASE,
			NodeBaseBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NODE_FORGE = register("node_forge", SatiscraftoryModBlocks.NODE_FORGE,
			NodeForgeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NODE_CREATIVE = register("node_creative", SatiscraftoryModBlocks.NODE_CREATIVE,
			NodeCreativeBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COAL_GENERATOR = register("coal_generator", SatiscraftoryModBlocks.COAL_GENERATOR,
			CoalGeneratorBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
