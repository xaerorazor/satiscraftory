package net.satiscraftory.procedures;

import net.satiscraftory.network.SatiscraftoryModVariables;
import net.satiscraftory.init.SatiscraftoryModParticleTypes;
import net.satiscraftory.init.SatiscraftoryModItems;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.Comparator;

import java.lang.reflect.Type;

public class NodeCreativeUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		BlockState Type = Blocks.AIR.defaultBlockState();
		ItemStack ItemFound = ItemStack.EMPTY;
		Entity LocalEntity = null;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).isEmpty()) {
			LocalEntity = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).stream()
					.sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if ((LocalEntity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getItem() == SatiscraftoryModItems.NODE_FINDER.get()) {
				found = (LocalEntity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("FinderActive");
			} else if ((LocalEntity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
					.getItem() == SatiscraftoryModItems.NODE_FINDER.get()) {
				found = (LocalEntity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("FinderActive");
			}
			if (found && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
				sy = 1;
				for (int index0 = 0; index0 < (int) (319 - world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)); index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (SatiscraftoryModParticleTypes.ORE_BEACON.get()), x, (y + sy), z, 5, 1, 1, 1, 0);
					sy = sy + 1;
				}
			}
		}
		ItemFound = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, new BlockPos(x, y, z), 0));
		if (SatiscraftoryModVariables.MapVariables.get(world).OreNodeInternalSpawn == true) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				if (_ent != null) {
					final int _slotid = 1;
					final ItemStack _setstack = ItemFound;
					_setstack.setCount(64);
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		} else {
			Type = (ItemFound.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState());
			sx = -2;
			found = false;
			for (int index1 = 0; index1 < (int) (5); index1++) {
				sy = 1;
				for (int index2 = 0; index2 < (int) (5); index2++) {
					sz = -2;
					for (int index3 = 0; index3 < (int) (6); index3++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Type.getBlock()) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == false) {
				sx = -2;
				for (int index4 = 0; index4 < (int) (5); index4++) {
					sy = 1;
					for (int index5 = 0; index5 < (int) (5); index5++) {
						sz = -2;
						for (int index6 = 0; index6 < (int) (6); index6++) {
							{
								BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
								BlockState _bs = Type;
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
			}
		}
		world.scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(), 10);
	}
}
