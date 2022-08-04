package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.entity.Entity;

public class NodeFinderItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(SatiscraftoryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockBeacon = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
