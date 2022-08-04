package net.satiscraftory.procedures;

import org.checkerframework.checker.units.qual.s;

import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class CreateNodeCommandExecutedProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return false;
		ItemStack OreGem = ItemStack.EMPTY;
		boolean NodeState = false;
		BlockState OreType = Blocks.AIR.defaultBlockState();
		double OreNum = 0;
		double OreTier = 0;
		double NewX = 0;
		double NewZ = 0;
		double NewY = 0;
		NewX = x;
		NewY = y - 1;
		NewZ = z;
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("")) {
			OreNum = Mth.nextInt(new Random(), 1, 13);
			OreTier = Mth.nextInt(new Random(), 1, 5);
			if (OreNum == 1) {
				OreGem = new ItemStack(Items.COAL);
			}
			{
				BlockPos _bp = new BlockPos(NewX, NewY, NewZ);
				BlockState _bs = SatiscraftoryModBlocks.NODE_BASE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(NewX, NewY, NewZ));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = OreGem;
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(NewX, NewY, NewZ));
				if (_ent != null) {
					final int _slotid = 1;
					final ItemStack _setstack = OreGem;
					_setstack.setCount(64);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ());
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("IsNatural", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ());
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("Tier", OreTier);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 5);
			return true;
		}
		NodeState = false;
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("coal")) {
			OreGem = new ItemStack(Items.COAL);
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("copper")) {
			OreGem = new ItemStack(Items.RAW_COPPER);
		}
		if (!(cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "").equals("")) {
			NewX = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("1") ? cmdparams.get("1").toString() : "");
			NewY = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("2") ? cmdparams.get("2").toString() : "");
			NewZ = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("3") ? cmdparams.get("3").toString() : "");
		}
		if (!(cmdparams.containsKey("4") ? cmdparams.get("4").toString() : "").equals("")) {
			OreTier = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("4") ? cmdparams.get("4").toString() : "");
			NodeState = true;
		}
		if (NodeState) {
			{
				BlockPos _bp = new BlockPos(NewX, NewY, NewZ);
				BlockState _bs = SatiscraftoryModBlocks.NODE_BASE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(NewX, NewY, NewZ));
				if (_ent != null) {
					final int _slotid = 0;
					final ItemStack _setstack = OreGem;
					_setstack.setCount(1);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(NewX, NewY, NewZ));
				if (_ent != null) {
					final int _slotid = 1;
					final ItemStack _setstack = OreGem;
					_setstack.setCount(64);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(NewX, NewY, NewZ);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putBoolean("IsNatural", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(NewX, NewY, NewZ);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("Tier", OreTier);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 5);
			return true;
		}
		return false;
	}
}
