package net.satiscraftory.procedures;

import net.minecraft.world.item.ItemStack;

public class NodeFinderItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("FinderActive", (false));
		itemstack.getOrCreateTag().putDouble("SearchRadius", 64);
	}
}
