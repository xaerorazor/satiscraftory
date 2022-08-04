package net.satiscraftory.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MachineWrenchEntitySwingsItemProcedure {
	public static boolean execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		if (!(entity instanceof Player)) {
			return false;
		}
		if (entity.isShiftKeyDown()) {
			if ((itemstack.getOrCreateTag().getString("Mode")).equals("Connect") || (itemstack.getOrCreateTag().getString("Mode")).equals("")) {
				itemstack.getOrCreateTag().putString("Mode", "Place");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Disconnect")) {
				itemstack.getOrCreateTag().putString("Mode", "Connect");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Remove")) {
				itemstack.getOrCreateTag().putString("Mode", "Disconnect");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Place")) {
				itemstack.getOrCreateTag().putString("Mode", "Remove");
			} else {
				itemstack.getOrCreateTag().putString("Mode", "Place");
			}
		} else {
			if ((itemstack.getOrCreateTag().getString("Mode")).equals("Remove") || (itemstack.getOrCreateTag().getString("Mode")).equals("")) {
				itemstack.getOrCreateTag().putString("Mode", "Place");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Place")) {
				itemstack.getOrCreateTag().putString("Mode", "Connect");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Connect")) {
				itemstack.getOrCreateTag().putString("Mode", "Disconnect");
			} else if ((itemstack.getOrCreateTag().getString("Mode")).equals("Disconnect")) {
				itemstack.getOrCreateTag().putString("Mode", "Remove");
			} else {
				itemstack.getOrCreateTag().putString("Mode", "Place");
			}
		}
		return true;
	}
}
