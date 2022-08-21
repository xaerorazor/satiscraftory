package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.TextComponent;

public class NodeInvestigatorEntitySwingsItemProcedure {
	public static InteractionResult execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent((new java.text.DecimalFormat("### /").format(SatiscraftoryModVariables.MapVariables.get(world).AvailableVA) + ""
							+ new java.text.DecimalFormat("###").format(SatiscraftoryModVariables.MapVariables.get(world).GlobalVA))),
					(false));
		return InteractionResult.SUCCESS;
	}
}
