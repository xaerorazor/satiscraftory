package net.satiscraftory.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

public class NodeFinderRightclickedProcedure {
	public static InteractionResult execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return InteractionResult.PASS;
		if (entity.isShiftKeyDown() == true) {
			itemstack.getOrCreateTag().putBoolean("FinderActive", (!itemstack.getOrCreateTag().getBoolean("FinderActive")));
		} else {
			if (itemstack.getOrCreateTag().getDouble("SearchRadius") == 64) {
				itemstack.getOrCreateTag().putDouble("SearchRadius", 128);
			} else if (itemstack.getOrCreateTag().getDouble("SearchRadius") == 128) {
				itemstack.getOrCreateTag().putDouble("SearchRadius", 64);
			} else {
				itemstack.getOrCreateTag().putDouble("SearchRadius", 64);
			}
			itemstack.getOrCreateTag().putDouble("SearchRadius", 64);
		}
		return InteractionResult.SUCCESS;
	}
}
