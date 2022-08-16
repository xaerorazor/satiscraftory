package net.satiscraftory.procedures;

import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class CoalGenGuiUpdateProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return false;
		double fireHeight = 0;
		if (guistate.get("text:Available") instanceof EditBox _tf)
			_tf.setValue((new java.text.DecimalFormat("Tanks #: ").format(new Object() {
				public int getBlockTanks(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getTanks()));
					return _retval.get();
				}
			}.getBlockTanks(world, new BlockPos(x, y, z))) + "" + new java.text.DecimalFormat("##### /").format(new Object() {
				public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
					return _retval.get();
				}
			}.getFluidTankLevel(world, new BlockPos(x, y, z), 1)) + new java.text.DecimalFormat("#####").format(new Object() {
				public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
					return _retval.get();
				}
			}.getFluidTankCapacity(world, new BlockPos(x, y, z), 1))));
		return true;
	}
}
