
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.client.particle.OreBeaconParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SatiscraftoryModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) SatiscraftoryModParticleTypes.ORE_BEACON.get(),
				OreBeaconParticle::provider);
	}
}
