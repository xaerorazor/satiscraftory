
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SatiscraftoryModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> PLAINNODE = GameRules.register("plainNode", GameRules.Category.MISC,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> OREUPDATETICKS = GameRules.register("oreUpdateTicks", GameRules.Category.MISC,
			GameRules.IntegerValue.create(40));
	public static final GameRules.Key<GameRules.BooleanValue> INTERNALSPAWN = GameRules.register("internalSpawn", GameRules.Category.MISC,
			GameRules.BooleanValue.create(false));
}
