package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;
import net.satiscraftory.init.SatiscraftoryModGameRules;
import net.satiscraftory.SatiscraftoryMod;

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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class NodeBaseBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack ItemType = ItemStack.EMPTY;
		boolean found = false;
		double OreType = 0;
		double LoopA = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		BlockState SpawnOre = Blocks.AIR.defaultBlockState();
		if (SatiscraftoryModVariables.MapVariables.get(world).OreVanilla == true) {
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
			OreType = Mth.nextInt(new Random(), 1, 13);
			if (OreType == 1) {
				ItemType = new ItemStack(Items.COAL);
				SpawnOre = Blocks.COAL_ORE.defaultBlockState();
			} else if (OreType == 2) {
				ItemType = new ItemStack(Items.RAW_COPPER);
				SpawnOre = Blocks.COPPER_ORE.defaultBlockState();
			} else if (OreType == 3) {
				ItemType = new ItemStack(Items.RAW_IRON);
				SpawnOre = Blocks.IRON_ORE.defaultBlockState();
			} else if (OreType == 4) {
				ItemType = new ItemStack(Items.REDSTONE);
				SpawnOre = Blocks.REDSTONE_ORE.defaultBlockState();
			} else if (OreType == 5) {
				ItemType = new ItemStack(Items.RAW_GOLD);
				SpawnOre = Blocks.GOLD_ORE.defaultBlockState();
			} else if (OreType == 6) {
				ItemType = new ItemStack(Items.LAPIS_LAZULI);
				SpawnOre = Blocks.LAPIS_ORE.defaultBlockState();
			} else if (OreType == 7) {
				ItemType = new ItemStack(Items.DIAMOND);
				SpawnOre = Blocks.DIAMOND_ORE.defaultBlockState();
			} else if (OreType == 8) {
				ItemType = new ItemStack(Items.EMERALD);
				SpawnOre = Blocks.EMERALD_ORE.defaultBlockState();
			} else if (OreType == 9) {
				ItemType = new ItemStack(Items.QUARTZ);
				SpawnOre = Blocks.NETHER_QUARTZ_ORE.defaultBlockState();
			} else if (OreType == 10) {
				ItemType = new ItemStack(Blocks.AMETHYST_CLUSTER);
				SpawnOre = Blocks.AMETHYST_BLOCK.defaultBlockState();
			} else if (OreType == 11) {
				ItemType = new ItemStack(Blocks.SAND);
				SpawnOre = Blocks.SAND.defaultBlockState();
			} else if (OreType == 12) {
				ItemType = new ItemStack(Blocks.GRAVEL);
				SpawnOre = Blocks.GRAVEL.defaultBlockState();
			} else if (OreType == 13) {
				ItemType = new ItemStack(Items.CLAY_BALL);
				SpawnOre = Blocks.CLAY.defaultBlockState();
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putString("Ore", ("" + ItemType));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = ItemType;
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			if (SatiscraftoryModVariables.MapVariables.get(world).DEBUG) {
				SatiscraftoryMod.LOGGER.debug(("Position:" + x + y + z));
				SatiscraftoryMod.LOGGER.debug(("Ore Type: " + (new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos(x, y, z), "Ore"))));
				SatiscraftoryMod.LOGGER.debug(("Tier: " + (new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world, new BlockPos(x, y, z), "Tier"))));
			}
			if (world.getLevelData().getGameRules().getBoolean(SatiscraftoryModGameRules.INTERNALSPAWN) == true) {
				LoopA = 0;
				for (int index1 = 0; index1 < (int) (1); index1++) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						if (_ent != null) {
							final int _slotid = (int) LoopA;
							final ItemStack _setstack = ItemType;
							_setstack.setCount(1);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				}
			} else if (world.getLevelData().getGameRules().getBoolean(SatiscraftoryModGameRules.INTERNALSPAWN) == false) {
				sx = -2;
				for (int index2 = 0; index2 < (int) (5); index2++) {
					sy = 1;
					for (int index3 = 0; index3 < (int) (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(x, y, z), "Tier")); index3++) {
						sz = -2;
						for (int index4 = 0; index4 < (int) (5); index4++) {
							if (!((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == SpawnOre.getBlock())) {
								world.setBlock(new BlockPos(x + sx, y + sy, z + sz), SpawnOre, 3);
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 1);
		}
		if (SatiscraftoryModVariables.MapVariables.get(world).AdditionalNodeStructure) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("satiscraftory", "orebase"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x + -3, y + 0, z + -3), new BlockPos(x + -3, y + 0, z + -3),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
