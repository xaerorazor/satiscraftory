
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.satiscraftory.init;

import net.satiscraftory.world.inventory.NodeGuiMenu;
import net.satiscraftory.world.inventory.CoalGenGuiMenu;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SatiscraftoryModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<NodeGuiMenu> NODE_GUI = register("node_gui", (id, inv, extraData) -> new NodeGuiMenu(id, inv, extraData));
	public static final MenuType<CoalGenGuiMenu> COAL_GEN_GUI = register("coal_gen_gui",
			(id, inv, extraData) -> new CoalGenGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
