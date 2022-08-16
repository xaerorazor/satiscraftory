package net.satiscraftory.procedures;

import net.satiscraftory.init.SatiscraftoryModFluids;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class CoalGeneratorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(Items.COAL == (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem() || Items.CHARCOAL == (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem())) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = 0;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, ItemStack.EMPTY);
					});
				}
			}
			if (0 == new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
					return _retval.get();
				}
			}.getAmount(world, new BlockPos(x, y, z), 0)) {
				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getTileData().putBoolean("Active", (false));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (true == (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "Active"))) {
			if (0 < new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
					return _retval.get();
				}
			}.getAmount(world, new BlockPos(x, y, z), 0)) {
				if (0 == new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
						return _retval.get();
					}
				}.getAmount(world, new BlockPos(x, y, z), 1)) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						if (_ent != null) {
							final int _slotid = 0;
							final ItemStack _setstack = (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0));
							_setstack.setCount((int) (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicInteger _retval = new AtomicInteger(0);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
									return _retval.get();
								}
							}.getAmount(world, new BlockPos(x, y, z), 0) - 1));
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						if (_ent != null) {
							final int _slotid = 1;
							final ItemStack _setstack = (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
												.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, new BlockPos(x, y, z), 0));
							_setstack.setCount(1);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				}
				if (new Object() {
					public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
						return _retval.get();
					}
				}.getFluidTankLevel(world, new BlockPos(x, y, z), 0) < new Object() {
					public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
						return _retval.get();
					}
				}.getFluidTankCapacity(world, new BlockPos(x, y, z), 0)) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						if (_ent != null) {
							final int _slotid = 1;
							final int _amount = 1;
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_slotid).copy();
									if (_stk.hurt(_amount, new Random(), null)) {
										_stk.shrink(1);
										_stk.setDamageValue(0);
									}
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
								}
							});
						}
					}
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						int _amount = 100;
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(capability -> capability
									.fill(new FluidStack(SatiscraftoryModFluids.VA.get(), _amount), IFluidHandler.FluidAction.EXECUTE));
					}
				}
			}
		}
	}
}
