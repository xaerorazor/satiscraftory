package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;
import net.satiscraftory.SatiscraftoryMod;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

public class NodeFinderEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		Entity localent = null;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Total = 0;
		double surface = 0;
		Total = 0;
		sx = (-1) * itemstack.getOrCreateTag().getDouble("SearchRadius");
		if (64 != itemstack.getOrCreateTag().getDouble("SearchRadius") || 128 != itemstack.getOrCreateTag().getDouble("SearchRadius")) {
			itemstack.getOrCreateTag().putDouble("SearchRadius", 64);
		}
		found = false;
		if (SatiscraftoryModVariables.MapVariables.get(world).DEBUG) {
			SatiscraftoryMod.LOGGER
					.debug((new java.text.DecimalFormat("Search Radius: ##.## ").format(itemstack.getOrCreateTag().getDouble("SearchRadius")) + ""
							+ entity.getDisplayName().getString()));
		}
		localent = entity;
		for (int index0 = 0; index0 < (int) (itemstack.getOrCreateTag().getDouble("SearchRadius") * 2); index0++) {
			sz = (-1) * itemstack.getOrCreateTag().getDouble("SearchRadius");
			for (int index1 = 0; index1 < (int) (itemstack.getOrCreateTag().getDouble("SearchRadius") * 2); index1++) {
				sy = itemstack.getOrCreateTag().getDouble("SearchRadius") * (-1);
				surface = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);
				for (int index2 = 0; index2 < (int) (itemstack.getOrCreateTag().getDouble("SearchRadius") * 2); index2++) {
					if (true == (new Object() {
						public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getTileData().getBoolean(tag);
							return false;
						}
					}.getValue(world, new BlockPos(x + sx, y + sy, z + sz), "IsNatural"))) {
						if (localent instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(new TextComponent(
									(new java.text.DecimalFormat("##/").format(x + sx) + "" + new java.text.DecimalFormat("##").format(z + sz))),
									(false));
						if (SatiscraftoryModVariables.MapVariables.get(world).DEBUG) {
							SatiscraftoryMod.LOGGER.debug((new java.text.DecimalFormat("##.##/").format(x + sx) + ""
									+ new java.text.DecimalFormat("##.##/").format(y + sy) + new java.text.DecimalFormat("##.##").format(z + sz)));
						}
						Total = Total + 1;
						break;
					}
					if (y + sy > surface) {
						break;
					}
					sy = sy + 1;
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		if (localent instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent((new java.text.DecimalFormat("Total Found: ##").format(Total))), (false));
	}
}
