package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.entity.Entity;

public class GetBlockBeaconProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(SatiscraftoryModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SatiscraftoryModVariables.PlayerVariables())).BlockBeacon;
	}
}
