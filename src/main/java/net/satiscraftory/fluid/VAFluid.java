
package net.satiscraftory.fluid;

import net.satiscraftory.init.SatiscraftoryModFluids;
import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;

public abstract class VAFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(SatiscraftoryModFluids.VA,
			SatiscraftoryModFluids.FLOWING_VA,
			FluidAttributes.builder(new ResourceLocation("satiscraftory:blocks/nodeside"), new ResourceLocation("satiscraftory:blocks/nodeside"))

					.density(100000).viscosity(100000).temperature(100000)

					.rarity(Rarity.EPIC))
			.explosionResistance(100f)

			.tickRate(1).levelDecreasePerBlock(3).slopeFindDistance(3)

			.block(() -> (LiquidBlock) SatiscraftoryModBlocks.VA.get());

	private VAFluid() {
		super(PROPERTIES);
	}

	public static class Source extends VAFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends VAFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
