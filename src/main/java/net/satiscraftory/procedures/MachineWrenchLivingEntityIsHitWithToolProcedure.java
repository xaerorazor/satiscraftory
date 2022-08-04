package net.satiscraftory.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.TextComponent;

public class MachineWrenchLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		sourceentity.hurt(DamageSource.MAGIC, (float) 0.01);
		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("Damage To Wrench Detected. It is a block wrench, not a sword or axe."), (true));
	}
}
