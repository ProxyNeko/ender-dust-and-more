package io.github.proxyneko.enderdustandmore.common.blocks;

import net.minecraft.block.BlockLever;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockMysteriousTorch extends BlockLever {

	public BlockMysteriousTorch() {
		//TODO Test for hardness and resistance settings then see if it needs sounds.
		setLightLevel(0.9375F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		if (state.getValue(POWERED)) {
			return;
		}
		EnumFacing face = state.getValue(FACING).getFacing();
		if (face.getYOffset() < 0) {
			return;
		}
		double x = pos.getX() + 0.5;
		double y = pos.getY() + 0.7;
		double z = pos.getZ() + 0.5;
		if (face.getAxis().isHorizontal()) {
			EnumFacing opposite = face.getOpposite();
			x += 0.27 * opposite.getXOffset();
			y += 0.22;
			z += 0.27 * opposite.getZOffset();
		}
		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0, 0.0, 0.0);
		world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0.0, 0.0, 0.0);
	}

	@Nonnull
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
