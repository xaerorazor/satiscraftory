package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class NodeFinderItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("FinderActive")) {
			{
				boolean _setval = true;
				entity.getCapability(SatiscraftoryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockBeacon = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(SatiscraftoryModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockBeacon = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
