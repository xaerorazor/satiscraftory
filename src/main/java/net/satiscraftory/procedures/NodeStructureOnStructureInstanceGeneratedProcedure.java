package net.satiscraftory.procedures;

import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class NodeStructureOnStructureInstanceGeneratedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xoffset = 0;
		double yoffset = 0;
		double zoffset = 0;
		xoffset = 3;
		yoffset = 0;
		zoffset = 3;
		world.setBlock(new BlockPos(x + xoffset, y + yoffset, z + zoffset), SatiscraftoryModBlocks.NODE_FORGE.get().defaultBlockState(), 3);
		NodeForgeBlockAddedProcedure.execute(world, (x + xoffset), (y + yoffset), (z + zoffset));
	}
}
