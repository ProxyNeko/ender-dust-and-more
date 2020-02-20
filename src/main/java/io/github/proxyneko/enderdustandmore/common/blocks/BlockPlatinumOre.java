package io.github.proxyneko.enderdustandmore.common.blocks;

import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockPlatinumOre extends Block {

	public BlockPlatinumOre() {
		super(new Material(MapColor.SNOW));
		setHardness(20);
		setHarvestLevel("pickaxe", 4);
		setResistance(4.0F);
		setSoundType(SoundType.STONE);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, @Nonnull Random random) {
		return quantityDropped(random) + random.nextInt(fortune + 1);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1 + random.nextInt(2);
	}

	@Nonnull
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return MoreItems.PLATINUM_DUST;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random random = world instanceof World ? ((World) world).rand : RANDOM;
		return 1 + random.nextInt(4);
	}

	@Nonnull
	@Override
	protected ItemStack getSilkTouchDrop(@Nonnull IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1);
	}
}
