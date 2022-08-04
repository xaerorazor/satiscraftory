package net.satiscraftory.procedures;

import net.satiscraftory.init.SatiscraftoryModGameRules;
import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class NodeForgeBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack ItemType = ItemStack.EMPTY;
		boolean found = false;
		double OreType = 0;
		double LoopA = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		BlockState SpawnOre = Blocks.AIR.defaultBlockState();
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SatiscraftoryModBlocks.NODE_CREATIVE.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("IsNatural", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("Tier", 3);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			LoopA = 0;
			for (int index0 = 0; index0 < (int) (2); index0++) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
					if (_ent != null) {
						final int _slotid = (int) LoopA;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
						});
					}
				}
				LoopA = LoopA + 1;
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 5);
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("IsNatural", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("Tier", (Mth.nextInt(new Random(), 1, 3)));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			LoopA = 0;
			for (int index1 = 0; index1 < (int) (2); index1++) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
					if (_ent != null) {
						final int _slotid = (int) LoopA;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
						});
					}
				}
				LoopA = LoopA + 1;
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = new ItemStack((ForgeRegistries.ITEMS.tags()
							.getTag(ItemTags.create(new ResourceLocation("forge:ores"))).getRandomElement(new Random()).orElseGet(() -> Items.AIR)));
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		}
		if (!world.getLevelData().getGameRules().getBoolean(SatiscraftoryModGameRules.PLAINNODE)) {
			sx = 1;
			if (1 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (2 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3),
								new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (3 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3),
								new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (4 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(
								_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3), new StructurePlaceSettings()
										.setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (5 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.FRONT_BACK).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (6 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3),
								new StructurePlaceSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.FRONT_BACK).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else if (7 == sx) {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(
								_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3), new StructurePlaceSettings()
										.setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.FRONT_BACK).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			} else {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
					if (template != null) {
						template.placeInWorld(
								_serverworld, new BlockPos(x - 3, y + 0, z - 3), new BlockPos(x - 3, y + 0, z - 3), new StructurePlaceSettings()
										.setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.FRONT_BACK).setIgnoreEntities(false),
								_serverworld.random, 3);
					}
				}
			}
		}
	}
}
