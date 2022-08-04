package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.level.LevelAccessor;

public class GetDebugProcedure {
	public static boolean execute(LevelAccessor world) {
		return SatiscraftoryModVariables.MapVariables.get(world).DEBUG;
	}
}
