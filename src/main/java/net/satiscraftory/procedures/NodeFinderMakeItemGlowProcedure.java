package net.satiscraftory.procedures;

import net.minecraft.world.item.ItemStack;

public class NodeFinderMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("FinderActive");
	}
}
