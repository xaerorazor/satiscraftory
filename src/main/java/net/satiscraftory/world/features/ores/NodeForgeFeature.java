
package net.satiscraftory.world.features.ores;

import net.satiscraftory.procedures.NodeBaseBlockValidPlacementConditionProcedure;
import net.satiscraftory.init.SatiscraftoryModBlocks;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.Set;
import java.util.Random;
import java.util.List;

public class NodeForgeFeature extends OreFeature {
	public static NodeForgeFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new NodeForgeFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("satiscraftory:node_forge", FEATURE,
				new OreConfiguration(NodeForgeFeatureRuleTest.INSTANCE, SatiscraftoryModBlocks.NODE_FORGE.get().defaultBlockState(), 1));
		PLACED_FEATURE = PlacementUtils.register("satiscraftory:node_forge", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(1), InSquarePlacement.spread(),
						HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(130)), BiomeFilter.biome()));
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("warped_forest"), new ResourceLocation("mushroom_fields"),
			new ResourceLocation("forest"), new ResourceLocation("stony_shore"), new ResourceLocation("sunflower_plains"),
			new ResourceLocation("sparse_jungle"), new ResourceLocation("birch_forest"), new ResourceLocation("flower_forest"),
			new ResourceLocation("snowy_slopes"), new ResourceLocation("bamboo_jungle"), new ResourceLocation("ice_spikes"),
			new ResourceLocation("dark_forest"), new ResourceLocation("plains"), new ResourceLocation("savanna"), new ResourceLocation("stony_peaks"),
			new ResourceLocation("frozen_peaks"), new ResourceLocation("meadow"), new ResourceLocation("old_growth_spruce_taiga"),
			new ResourceLocation("snowy_beach"), new ResourceLocation("savanna_plateau"), new ResourceLocation("snowy_plains"),
			new ResourceLocation("taiga"), new ResourceLocation("jagged_peaks"), new ResourceLocation("snowy_taiga"), new ResourceLocation("swamp"),
			new ResourceLocation("eroded_badlands"), new ResourceLocation("badlands"), new ResourceLocation("old_growth_birch_forest"),
			new ResourceLocation("grove"), new ResourceLocation("windswept_hills"), new ResourceLocation("old_growth_pine_taiga"),
			new ResourceLocation("beach"), new ResourceLocation("wooded_badlands"), new ResourceLocation("windswept_savanna"),
			new ResourceLocation("windswept_forest"), new ResourceLocation("jungle"), new ResourceLocation("windswept_gravelly_hills"),
			new ResourceLocation("desert"));
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public NodeForgeFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!NodeBaseBlockValidPlacementConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class NodeForgeFeatureRuleTest extends RuleTest {
		static final NodeForgeFeatureRuleTest INSTANCE = new NodeForgeFeatureRuleTest();
		private static final com.mojang.serialization.Codec<NodeForgeFeatureRuleTest> CODEC = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		private static final RuleTestType<NodeForgeFeatureRuleTest> CUSTOM_MATCH = () -> CODEC;

		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			Registry.register(Registry.RULE_TEST, new ResourceLocation("satiscraftory:node_forge_match"), CUSTOM_MATCH);
		}

		private List<Block> base_blocks = null;

		public boolean test(BlockState blockAt, Random random) {
			if (base_blocks == null) {
				base_blocks = List.of(Blocks.STONE, Blocks.GRASS_BLOCK, Blocks.MYCELIUM, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL,
						Blocks.ROOTED_DIRT);
			}
			return base_blocks.contains(blockAt.getBlock());
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}
}
