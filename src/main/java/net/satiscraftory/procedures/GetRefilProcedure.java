package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.level.LevelAccessor;

public class GetRefilProcedure {
	public static double execute(LevelAccessor world) {
		return SatiscraftoryModVariables.MapVariables.get(world).OreNodeRefillTicks;
	}
}
