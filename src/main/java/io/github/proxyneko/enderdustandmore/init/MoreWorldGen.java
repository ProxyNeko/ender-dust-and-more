package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.api.blocks.MoreBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MoreWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case -1:
				generateNetherOre(world, random, chunkX, chunkZ);
				break;
			case 0:
				generateOverworldOre(world, random, chunkX, chunkZ);
				break;
			case 1:
				generateEndOre(world, random, chunkX, chunkZ);
				break;
		}
	}

	private void generateNetherOre(World world, Random random, int x, int z) {
		if (ModConfig.netherOres.netherEnderOreGen) {
			generateOre(MoreBlocks.ENDER_ORE_NETHER, world, random, x, z, ModConfig.netherOres.nEnderOreMinVein, ModConfig.netherOres.nEnderOreMaxVein, ModConfig.netherOres.nEnderOreChance, ModConfig.netherOres.nEnderOreMinY, ModConfig.netherOres.nEnderOreMaxY, Blocks.NETHERRACK);
		}
		if (ModConfig.netherOres.netherPlatinumOreGen) {
			generateOre(MoreBlocks.PLATINUM_ORE_NETHER, world, random, x, z, ModConfig.netherOres.nPlatinumOreMinVein, ModConfig.netherOres.nPlatinumOreMaxVein, ModConfig.netherOres.nPlatinumOreChance, ModConfig.netherOres.nPlatinumOreMinY, ModConfig.netherOres.nPlatinumOreMaxY, Blocks.NETHERRACK);
		}
	}

	private void generateOverworldOre(World world, Random random, int x, int z) {
		if (ModConfig.overworldOres.overworldEnderOreGen) {
			generateOre(MoreBlocks.ENDER_ORE, world, random, x, z, ModConfig.overworldOres.enderOreMinVein, ModConfig.overworldOres.enderOreMaxVein, ModConfig.overworldOres.enderOreChance, ModConfig.overworldOres.enderOreMinY, ModConfig.overworldOres.enderOreMaxY, Blocks.STONE);
		}
		if (ModConfig.overworldOres.overworldPlatinumOreGen) {
			generateOre(MoreBlocks.PLATINUM_ORE, world, random, x, z, ModConfig.overworldOres.platinumOreMinVein, ModConfig.overworldOres.platinumOreMaxVein, ModConfig.overworldOres.platinumOreChance, ModConfig.overworldOres.platinumOreMinY, ModConfig.overworldOres.platinumOreMaxY, Blocks.STONE);
		}
	}

	private void generateEndOre(World world, Random random, int x, int z) {
		if (ModConfig.endOres.endEnderOreGen) {
			generateOre(MoreBlocks.ENDER_ORE_END, world, random, x, z, ModConfig.endOres.eEnderOreMinVein, ModConfig.endOres.eEnderOreMaxVein, ModConfig.endOres.eEnderOreChance, ModConfig.endOres.eEnderOreMinY, ModConfig.endOres.eEnderOreMaxY, Blocks.END_STONE);
		}
		if (ModConfig.endOres.endPlatinumOreGen) {
			generateOre(MoreBlocks.PLATINUM_ORE_END, world, random, x, z, ModConfig.endOres.ePlatinumOreMinVein, ModConfig.endOres.ePlatinumOreMaxVein, ModConfig.endOres.ePlatinumOreChance, ModConfig.endOres.ePlatinumOreMinY, ModConfig.endOres.ePlatinumOreMaxY, Blocks.END_STONE);
		}
	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int spawnChance, int minY, int maxY, Block generateIn) {
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockMatcher.forBlock(generateIn));
		for (int i = 0; i < spawnChance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
		}
	}
}
