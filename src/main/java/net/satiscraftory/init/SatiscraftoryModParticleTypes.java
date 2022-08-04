
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.SatiscraftoryMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class SatiscraftoryModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SatiscraftoryMod.MODID);
	public static final RegistryObject<ParticleType<?>> ORE_BEACON = REGISTRY.register("ore_beacon", () -> new SimpleParticleType(true));
}
