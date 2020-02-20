package io.github.proxyneko.enderdustandmore;

import io.github.proxyneko.enderdustandmore.api.items.MoreItems;
import io.github.proxyneko.enderdustandmore.init.MoreBlockRegistry;
import io.github.proxyneko.enderdustandmore.init.MoreItemRegistry;
import io.github.proxyneko.enderdustandmore.init.MoreRecipes;
import io.github.proxyneko.enderdustandmore.init.MoreWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
	name = EnderDustAndMore.NAME,
	modid = EnderDustAndMore.MODID,
	version = EnderDustAndMore.VERSION,
	updateJSON = "https://raw.githubusercontent.com/proxyneko/ender-dust-and-more/master/update.json",
	certificateFingerprint = "@FINGERPRINT@",
	acceptedMinecraftVersions = "[1.12, 1.12.2]",
	dependencies = "required-after:proxyslib@[1.3.0,)"
)
public class EnderDustAndMore {

	public static final String NAME = "Ender Dust And More";
	public static final String MODID = "enderdustandmore";
	public static final String VERSION = "1.4.0";
	public static final Logger LOGGER = LogManager.getLogger(NAME);

	public static final CreativeTabs TAB = new CreativeTabs(MODID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MoreItems.ENDER_DUST);
		}
	};

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		LOGGER.warn("Invalid /no fingerprint detected! The file " + event.getSource().getName()
			+ " may have been tampered with. This version will NOT be supported!"
			+ " Please download the mod from CurseForge for a supported and signed version of the mod.");
	}

	public static final ItemArmor.ArmorMaterial ENDER_ARMOR
		= EnumHelper.addArmorMaterial("ender", MODID + ":ender", 1000,
		new int[]{4, 6, 8, 4}, 28, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 10);

	public static final Item.ToolMaterial ENDER
		= EnumHelper.addToolMaterial("ender", 4, 1000, 16.0F,
		15.0F, 28);

	public static final ItemArmor.ArmorMaterial PLATINUM_ARMOR
		= EnumHelper.addArmorMaterial("platinum", MODID + ":platinum", 1850,
		new int[]{5, 7, 10, 5}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 20);

	public static final Item.ToolMaterial PLATINUM
		= EnumHelper.addToolMaterial("platinum", 5, 1850, 12.0F,
		20.0F, 16);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER.info("A new ore is forming...");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		LOGGER.info("Looks like the Endermen like it!");
		MoreRecipes.init();
		MoreItemRegistry.initItemOreDict();
		MoreBlockRegistry.initBlockOreDict();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LOGGER.info("The Endermen have made a home out of the ore! Careful when you mine it.");
		new MoreWorldGen();
	}
}
