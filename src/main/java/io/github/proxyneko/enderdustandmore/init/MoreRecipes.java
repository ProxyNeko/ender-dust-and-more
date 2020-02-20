package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.api.blocks.MoreBlocks;
import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreRecipes {

	public static void init() {
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.ENDER_ORE), new ItemStack(MoreItems.ENDER_NUGGET), 1.25f);
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.ENDER_ORE_NETHER), new ItemStack(MoreItems.ENDER_NUGGET), 1.25f);
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.ENDER_ORE_END), new ItemStack(MoreItems.ENDER_NUGGET), 1.25f);
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.PLATINUM_ORE), new ItemStack(MoreItems.PLATINUM_NUGGET), 0.25f);
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.PLATINUM_ORE_NETHER), new ItemStack(MoreItems.PLATINUM_NUGGET), 0.25f);
		GameRegistry.addSmelting(new ItemStack(MoreBlocks.PLATINUM_ORE_END), new ItemStack(MoreItems.PLATINUM_NUGGET), 0.25f);
	}
}
