package io.github.proxyneko.enderdustandmore.common.blocks;

import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import io.github.proxyneko.enderdustandmore.init.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockEnderOre extends Block {

	public static final PropertyBool LIT = PropertyBool.create("lit");

	public BlockEnderOre() {
		super(new Material(MapColor.GREEN));
		setDefaultState(getBlockState().getBaseState().withProperty(LIT, false));
		setTickRandomly(true);
		setHardness(15);
		setHarvestLevel("pickaxe", 3);
		setResistance(2.0F);
		setSoundType(SoundType.STONE);
	}

	@Override
	public void dropBlockAsItemWithChance(World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, float chance, int fortune) {
		super.dropBlockAsItemWithChance(world, pos, state, chance, fortune);
		EntityPlayer player = harvesters.get();
		if (player instanceof FakePlayer && !ModConfig.miscConfig.fakePlayerSpawnEnderman) {
			return;
		}
		if (!world.isRemote && world.rand.nextDouble() <= ModConfig.miscConfig.endermanSpawn) {
			EntityEnderman enderman = (new EntityEnderman(world));
			if (enderman != null) {
				double x = pos.getX() + 0.5;
				double y = pos.getY() + 1;
				double z = pos.getZ() + 0.5;
				float yaw = world.rand.nextFloat() * 360F;
				float pitch = 0.0F;
				enderman.setLocationAndAngles(x, y, z, yaw, pitch);
				world.spawnEntity(enderman);
				enderman.playLivingSound();
			}
		}
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
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return MoreItems.ENDER_DUST;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random random = world instanceof World ? ((World) world).rand : RANDOM;
		return 1 + random.nextInt(4);
	}

	@Nonnull
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LIT);
	}

	@Nonnull
	@Override
	@SuppressWarnings("deprecation")
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(LIT, (meta & 0b100) != 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0b000;
		if (state.getValue(LIT)) {
			meta |= 0b100;
		}
		return meta;
	}

	@Override
	public int getLightValue(@Nonnull IBlockState state, IBlockAccess world, @Nonnull BlockPos pos) {
		return state.getValue(LIT) ? 9 : 0;
	}

	@Override
	public int tickRate(World world) {
		return 30;
	}

	@Override
	public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
		activate(world, pos, world.getBlockState(pos));
		super.onBlockClicked(world, pos, player);
	}

	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		activate(world, pos, world.getBlockState(pos));
		super.onEntityWalk(world, pos, entity);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		activate(world, pos, state);
		return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		if (state.getValue(LIT)) {
			world.setBlockState(pos, state.withProperty(LIT, false));
		}
	}

	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		if (state.getValue(LIT)) {
			spawnParticles(world, pos);
		}
	}

	private void activate(World world, BlockPos pos, IBlockState state) {
		spawnParticles(world, pos);
		if (!state.getValue(LIT)) {
			world.setBlockState(pos, state.withProperty(LIT, true));
		}
	}

	private void spawnParticles(World world, BlockPos pos) {
		AxisAlignedBB aabb = new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
		double particleDistance = 0.0625;
		for (EnumFacing side : EnumFacing.VALUES) {
			double x = aabb.minX + world.rand.nextFloat();
			double y = aabb.minY + world.rand.nextFloat();
			double z = aabb.minZ + world.rand.nextFloat();
			if (!world.getBlockState(pos.add(side.getDirectionVec())).isOpaqueCube()) {
				switch (side) {
					case UP:
						y = aabb.maxY + particleDistance;
						break;
					case DOWN:
						y = aabb.minY - particleDistance;
						break;
					case SOUTH:
						z = aabb.maxZ + particleDistance;
						break;
					case NORTH:
						z = aabb.minZ - particleDistance;
						break;
					case EAST:
						x = aabb.maxX + particleDistance;
						break;
					case WEST:
						x = aabb.minX - particleDistance;
						break;
				}
			}
			if (x < aabb.minX || x > aabb.maxX || y < aabb.minY || y > aabb.maxY || z < aabb.minZ || z > aabb.maxZ) {
				//R=0.9,G=0.3,B=1
				world.spawnParticle(EnumParticleTypes.REDSTONE, x, y, z, 0.9, 0.3, 1.0);
			}
		}
	}
}
