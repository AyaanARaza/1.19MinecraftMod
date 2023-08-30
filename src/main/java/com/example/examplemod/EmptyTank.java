package com.example.examplemod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class EmptyTank extends AbstractGlassBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public EmptyTank(Properties p_49795_) {
		super(p_49795_);
		// TODO Auto-generated constructor stub
	}

	public BlockState updateShape(BlockState p_54440_, Direction p_54441_, BlockState p_54442_, LevelAccessor p_54443_,
			BlockPos p_54444_, BlockPos p_54445_) {
		if (p_54440_.getValue(WATERLOGGED)) {
			p_54443_.scheduleTick(p_54444_, Fluids.WATER, Fluids.WATER.getTickDelay(p_54443_));
		}

		return p_54440_;
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState p_221384_) {
		return p_221384_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_221384_);
	}

	public void animateTick(BlockState p_221374_, Level p_221375_, BlockPos p_221376_, RandomSource p_221377_) {
		if (p_221375_.isRainingAt(p_221376_.above())) {
			if (p_221377_.nextInt(15) == 1) {
				BlockPos blockpos = p_221376_.below();
				BlockState blockstate = p_221375_.getBlockState(blockpos);
				if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(p_221375_, blockpos, Direction.UP)) {
					double d0 = (double) p_221376_.getX() + p_221377_.nextDouble();
					double d1 = (double) p_221376_.getY() - 0.05D;
					double d2 = (double) p_221376_.getZ() + p_221377_.nextDouble();
					p_221375_.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
		p_54447_.add(WATERLOGGED);
	}

}
