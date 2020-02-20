package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.EnderDustAndMore;
import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import io.github.proxyneko.enderdustandmore.common.Items.ItemDivineHammer;
import com.mcmoddev.proxyslib.items.BaseAxe;
import com.mcmoddev.proxyslib.items.BasePickaxe;
import com.mcmoddev.proxyslib.util.RegistryUtils;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = EnderDustAndMore.MODID)
public class MoreItemRegistry {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "ender_dust", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "ender_nugget", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "ender_ingot", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemSword(EnderDustAndMore.ENDER), EnderDustAndMore.MODID,
				"ender_sword", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new BasePickaxe(EnderDustAndMore.ENDER), EnderDustAndMore.MODID,
				"ender_pickaxe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemSpade(EnderDustAndMore.ENDER), EnderDustAndMore.MODID,
				"ender_shovel", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new BaseAxe(EnderDustAndMore.ENDER), EnderDustAndMore.MODID,
				"ender_axe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemHoe(EnderDustAndMore.ENDER), EnderDustAndMore.MODID,
				"ender_hoe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.ENDER_ARMOR, -1,
				EntityEquipmentSlot.HEAD), EnderDustAndMore.MODID, "ender_helmet", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.ENDER_ARMOR, -1,
				EntityEquipmentSlot.CHEST), EnderDustAndMore.MODID, "ender_chestplate", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.ENDER_ARMOR, -1,
				EntityEquipmentSlot.LEGS), EnderDustAndMore.MODID, "ender_leggings", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.ENDER_ARMOR, -1,
				EntityEquipmentSlot.FEET), EnderDustAndMore.MODID, "ender_boots", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "platinum_dust", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "platinum_nugget", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "platinum_ingot", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemSword(EnderDustAndMore.PLATINUM), EnderDustAndMore.MODID,
				"platinum_sword", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new BasePickaxe(EnderDustAndMore.PLATINUM), EnderDustAndMore.MODID,
				"platinum_pickaxe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemSpade(EnderDustAndMore.PLATINUM), EnderDustAndMore.MODID,
				"platinum_shovel", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new BaseAxe(EnderDustAndMore.PLATINUM), EnderDustAndMore.MODID,
				"platinum_axe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemHoe(EnderDustAndMore.PLATINUM), EnderDustAndMore.MODID,
				"platinum_hoe", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.PLATINUM_ARMOR, -1,
				EntityEquipmentSlot.HEAD), EnderDustAndMore.MODID, "platinum_helmet", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.PLATINUM_ARMOR, -1,
				EntityEquipmentSlot.CHEST), EnderDustAndMore.MODID, "platinum_chestplate", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.PLATINUM_ARMOR, -1,
				EntityEquipmentSlot.LEGS), EnderDustAndMore.MODID, "platinum_leggings", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemArmor(EnderDustAndMore.PLATINUM_ARMOR, -1,
				EntityEquipmentSlot.FEET), EnderDustAndMore.MODID, "platinum_boots", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "obsidian_rod", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID, "divine_rod", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new Item(), EnderDustAndMore.MODID,
				"divine_hammer_head", EnderDustAndMore.TAB),
			RegistryUtils.nameItem(new ItemDivineHammer(), EnderDustAndMore.MODID,
				"divine_hammer", EnderDustAndMore.TAB)
		);
	}

	public static void initItemOreDict() {
		OreDictionary.registerOre("dustEnder", MoreItems.ENDER_DUST);
		OreDictionary.registerOre("nuggetEnder", MoreItems.ENDER_NUGGET);
		OreDictionary.registerOre("ingotEnder", MoreItems.ENDER_INGOT);
		OreDictionary.registerOre("dustPlatinum", MoreItems.PLATINUM_DUST);
		OreDictionary.registerOre("nuggetPlatinum", MoreItems.PLATINUM_NUGGET);
		OreDictionary.registerOre("ingotPlatinum", MoreItems.PLATINUM_INGOT);
	}
}
