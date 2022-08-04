
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SatiscraftoryModTabs {
	public static CreativeModeTab TAB_SATISCRAFTORY;

	public static void load() {
		TAB_SATISCRAFTORY = new CreativeModeTab("tabsatiscraftory") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(SatiscraftoryModBlocks.NODE_CREATIVE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
