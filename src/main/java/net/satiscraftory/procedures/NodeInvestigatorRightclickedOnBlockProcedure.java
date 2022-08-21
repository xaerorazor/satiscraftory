package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;
import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class NodeInvestigatorRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SatiscraftoryModBlocks.NODE_BASE.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == SatiscraftoryModBlocks.NODE_FORGE.get()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(((" Ore: " + (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, new BlockPos(x, y, z), 0))) + "" + (" IsNatural: " + (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(x, y, z), "IsNatural"))) + (" Tier: " + new java.text.DecimalFormat("##").format(new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "Tier"))) + (" Fill: " + new java.text.DecimalFormat("##").format(new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
						return _retval.get();
					}
				}.getAmount(world, new BlockPos(x, y, z), 1))))), (false));
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == SatiscraftoryModBlocks.COAL_GENERATOR.get()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((new java.text.DecimalFormat("##.## / ").format(new Object() {
					public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
						return _retval.get();
					}
				}.getFluidTankLevel(world, new BlockPos(x, y, z), 1)) + "" + new java.text.DecimalFormat("##.## VA ").format(new Object() {
					public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
						return _retval.get();
					}
				}.getFluidTankCapacity(world, new BlockPos(x, y, z), 1)) + "Active:" + (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(x, y, z), "Active")))), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(
						(new java.text.DecimalFormat("##.## / ").format(SatiscraftoryModVariables.MapVariables.get(world).AvailableVA) + ""
								+ new java.text.DecimalFormat("##.## VA Global ").format(SatiscraftoryModVariables.MapVariables.get(world).GlobalVA)
								+ new java.text.DecimalFormat("##.## VAStorageBlocks ")
										.format(SatiscraftoryModVariables.MapVariables.get(world).VAStorageBlocks)
								+ new java.text.DecimalFormat("##.## VAUsed").format(SatiscraftoryModVariables.MapVariables.get(world).VAUsed))),
						(false));
		}
		return InteractionResult.SUCCESS;
	}
}
