package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.EnderDustAndMore;
import io.github.proxyneko.enderdustandmore.api.blocks.MoreBlocks;
import io.github.proxyneko.enderdustandmore.common.blocks.BlockEnderOre;
import io.github.proxyneko.enderdustandmore.common.blocks.BlockMysteriousTorch;
import io.github.proxyneko.enderdustandmore.common.blocks.BlockPlatinumOre;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = EnderDustAndMore.MODID)
public class MoreBlockRegistry {

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			RegistryUtils.nameBlock(new BlockEnderOre(), EnderDustAndMore.MODID,
				"ender_ore", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockEnderOre(), EnderDustAndMore.MODID,
				"ender_ore_nether", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockEnderOre(), EnderDustAndMore.MODID,
				"ender_ore_end", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new Block(Material.IRON), EnderDustAndMore.MODID,
				"ender_block", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockPlatinumOre(), EnderDustAndMore.MODID,
				"platinum_ore", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockPlatinumOre(), EnderDustAndMore.MODID,
				"platinum_ore_nether", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockPlatinumOre(), EnderDustAndMore.MODID,
				"platinum_ore_end", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new Block(Material.IRON), EnderDustAndMore.MODID,
				"platinum_block", EnderDustAndMore.TAB),
			RegistryUtils.nameBlock(new BlockMysteriousTorch(), EnderDustAndMore.MODID,
				"mysterious_torch", EnderDustAndMore.TAB)
		);
	}

	@SubscribeEvent
	public static void registerBlockItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			RegistryUtils.nameBlockItem(MoreBlocks.ENDER_ORE),
			RegistryUtils.nameBlockItem(MoreBlocks.ENDER_ORE_END),
			RegistryUtils.nameBlockItem(MoreBlocks.ENDER_ORE_NETHER),
			RegistryUtils.nameBlockItem(MoreBlocks.ENDER_BLOCK),
			RegistryUtils.nameBlockItem(MoreBlocks.PLATINUM_ORE),
			RegistryUtils.nameBlockItem(MoreBlocks.PLATINUM_ORE_END),
			RegistryUtils.nameBlockItem(MoreBlocks.PLATINUM_ORE_NETHER),
			RegistryUtils.nameBlockItem(MoreBlocks.PLATINUM_BLOCK),
			RegistryUtils.nameBlockItem(MoreBlocks.MYSTERIOUS_TORCH)
		);
	}

	public static void initBlockOreDict() {
		OreDictionary.registerOre("oreEnder", MoreBlocks.ENDER_ORE);
		OreDictionary.registerOre("oreEnder", MoreBlocks.ENDER_ORE_NETHER);
		OreDictionary.registerOre("oreEnder", MoreBlocks.ENDER_ORE_END);
		OreDictionary.registerOre("blockEnder", MoreBlocks.ENDER_BLOCK);
		OreDictionary.registerOre("orePlatinum", MoreBlocks.PLATINUM_ORE);
		OreDictionary.registerOre("orePlatinum", MoreBlocks.PLATINUM_ORE_NETHER);
		OreDictionary.registerOre("orePlatinum", MoreBlocks.PLATINUM_ORE_END);
		OreDictionary.registerOre("blockPlatinum", MoreBlocks.PLATINUM_BLOCK);
	}
}
