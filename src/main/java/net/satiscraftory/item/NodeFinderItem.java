
package net.satiscraftory.item;

import net.satiscraftory.procedures.NodeFinderRightclickedProcedure;
import net.satiscraftory.procedures.NodeFinderMakeItemGlowProcedure;
import net.satiscraftory.procedures.NodeFinderItemIsDroppedByPlayerProcedure;
import net.satiscraftory.procedures.NodeFinderItemIsCraftedsmeltedProcedure;
import net.satiscraftory.procedures.NodeFinderItemInInventoryTickProcedure;
import net.satiscraftory.procedures.NodeFinderItemInHandTickProcedure;
import net.satiscraftory.procedures.NodeFinderEntitySwingsItemProcedure;
import net.satiscraftory.init.SatiscraftoryModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class NodeFinderItem extends Item {
	public NodeFinderItem() {
		super(new Item.Properties().tab(SatiscraftoryModTabs.TAB_SATISCRAFTORY).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 3;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return NodeFinderMakeItemGlowProcedure.execute(itemstack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		NodeFinderRightclickedProcedure.execute(entity, itemstack);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		return NodeFinderRightclickedProcedure.execute(context.getPlayer(), context.getItemInHand());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		NodeFinderEntitySwingsItemProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		NodeFinderItemIsCraftedsmeltedProcedure.execute(itemstack);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			NodeFinderItemInHandTickProcedure.execute(entity, itemstack);
		NodeFinderItemInInventoryTickProcedure.execute(entity);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		NodeFinderItemIsDroppedByPlayerProcedure.execute(itemstack);
		return true;
	}
}
