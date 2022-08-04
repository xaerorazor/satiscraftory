package net.satiscraftory.procedures;

import net.minecraft.world.item.ItemStack;

public class NodeFinderItemIsDroppedByPlayerProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("FinderActive", (false));
	}
}
