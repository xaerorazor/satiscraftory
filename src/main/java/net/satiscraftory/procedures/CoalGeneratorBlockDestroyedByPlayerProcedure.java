package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class CoalGeneratorBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SatiscraftoryModVariables.MapVariables.get(world).GlobalVA = SatiscraftoryModVariables.MapVariables.get(world).GlobalVA - 10000;
		SatiscraftoryModVariables.MapVariables.get(world).syncData(world);
		SatiscraftoryModVariables.MapVariables.get(world).AvailableVA = SatiscraftoryModVariables.MapVariables.get(world).AvailableVA - new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos(x, y, z), 1);
		SatiscraftoryModVariables.MapVariables.get(world).syncData(world);
		SatiscraftoryModVariables.MapVariables.get(world).VAStorageBlocks = SatiscraftoryModVariables.MapVariables.get(world).VAStorageBlocks - 1;
		SatiscraftoryModVariables.MapVariables.get(world).syncData(world);
	}
}
