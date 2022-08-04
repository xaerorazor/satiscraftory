
package net.satiscraftory.block;

import net.satiscraftory.init.SatiscraftoryModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class VABlock extends LiquidBlock {
	public VABlock() {
		super(() -> (FlowingFluid) SatiscraftoryModFluids.VA.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f)
				.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)

		);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
