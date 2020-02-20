package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.EnderDustAndMore;
import io.github.proxyneko.enderdustandmore.api.blocks.MoreBlocks;
import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = EnderDustAndMore.MODID, value = Side.CLIENT)
public class MoreRenderingRegistry {

	@SubscribeEvent
	public static void registerRendering(ModelRegistryEvent event) {
		RegistryUtils.registerItemModel(MoreItems.ENDER_DUST, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_NUGGET, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_INGOT, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_SWORD, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_PICKAXE, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_SHOVEL, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_AXE, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_HOE, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_HELMET, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_CHESTPLATE, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_LEGGINGS, 0);
		RegistryUtils.registerItemModel(MoreItems.ENDER_BOOTS, 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.ENDER_BLOCK), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.ENDER_ORE), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.ENDER_ORE_NETHER), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.ENDER_ORE_END), 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_DUST, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_NUGGET, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_INGOT, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_SWORD, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_PICKAXE, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_SHOVEL, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_AXE, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_HOE, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_HELMET, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_CHESTPLATE, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_LEGGINGS, 0);
		RegistryUtils.registerItemModel(MoreItems.PLATINUM_BOOTS, 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.PLATINUM_BLOCK), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.PLATINUM_ORE), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.PLATINUM_ORE_NETHER), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.PLATINUM_ORE_END), 0);
		RegistryUtils.registerItemModel(Item.getItemFromBlock(MoreBlocks.MYSTERIOUS_TORCH), 0);
		RegistryUtils.registerItemModel(MoreItems.OBSIDIAN_ROD, 0);
		RegistryUtils.registerItemModel(MoreItems.DIVINE_ROD, 0);
		RegistryUtils.registerItemModel(MoreItems.DIVINE_HAMMER_HEAD, 0);
		RegistryUtils.registerItemModel(MoreItems.DIVINE_HAMMER, 0);
	}
}
