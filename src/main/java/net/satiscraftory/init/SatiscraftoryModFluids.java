
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.fluid.VAFluid;
import net.satiscraftory.SatiscraftoryMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class SatiscraftoryModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, SatiscraftoryMod.MODID);
	public static final RegistryObject<Fluid> VA = REGISTRY.register("va", () -> new VAFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_VA = REGISTRY.register("flowing_va", () -> new VAFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(VA.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_VA.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
