package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class CoalGeneratorBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putBoolean("Active", (false));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		SatiscraftoryModVariables.MapVariables.get(world).GlobalVA = SatiscraftoryModVariables.MapVariables.get(world).GlobalVA + 10000;
		SatiscraftoryModVariables.MapVariables.get(world).syncData(world);
	}
}
