package io.github.proxyneko.enderdustandmore.init;

import io.github.proxyneko.enderdustandmore.EnderDustAndMore;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = EnderDustAndMore.MODID, category = "")
@Mod.EventBusSubscriber(modid = EnderDustAndMore.MODID)
public class ModConfig {

	private static final String LANG = EnderDustAndMore.MODID + ".config.";

	@Config.LangKey(LANG + "overworldOres")
	@Config.Comment({"Overworld ore generation settings."})
	public static ConfigOverworldOres overworldOres = new ConfigOverworldOres();

	@Config.LangKey(LANG + "netherOres")
	@Config.Comment({"Nether ore generation settings."})
	public static ConfigNetherOres netherOres = new ConfigNetherOres();

	@Config.LangKey(LANG + "endOres")
	@Config.Comment({"The End ore generation settings."})
	public static ConfigEndOres endOres = new ConfigEndOres();

	@Config.LangKey(LANG + "miscConfig")
	@Config.Comment({"Settings for other content. (Misc)"})
	public static ConfigMisc miscConfig = new ConfigMisc();

	@SubscribeEvent
	@SuppressWarnings("unused")
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(EnderDustAndMore.MODID)) {
			ConfigManager.sync(EnderDustAndMore.MODID, Config.Type.INSTANCE);
		}
	}

	//TODO Cleanup names and such.
	public static class ConfigOverworldOres {

		@Config.LangKey(LANG + "enderOreGen")
		@Config.Comment({"Set to false to disable Ender Ore generation in the Overworld."})
		public boolean overworldEnderOreGen = true;

		@Config.LangKey(LANG + "enderOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Ender Ore in a chunk."})
		public int enderOreChance = 10;

		@Config.LangKey(LANG + "enderOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Ender Ore will spawn."})
		public int enderOreMinY = 1;

		@Config.LangKey(LANG + "enderOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Ender Ore will spawn."})
		public int enderOreMaxY = 10;

		@Config.LangKey(LANG + "enderOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int enderOreMinVein = 4;

		@Config.LangKey(LANG + "enderOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int enderOreMaxVein = 6;

		@Config.LangKey(LANG + "platinumOreGen")
		@Config.Comment({"Set to false to disable Platinum Ore generation in the Overworld."})
		public boolean overworldPlatinumOreGen = false;

		@Config.LangKey(LANG + "platinumOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Platinum Ore in a chunk."})
		public int platinumOreChance = 8;

		@Config.LangKey(LANG + "platinumOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Platinum Ore will spawn."})
		public int platinumOreMinY = 30;

		@Config.LangKey(LANG + "platinumOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Platinum Ore will spawn."})
		public int platinumOreMaxY = 35;

		@Config.LangKey(LANG + "platinumOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int platinumOreMinVein = 1;

		@Config.LangKey(LANG + "platinumOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int platinumOreMaxVein = 2;
	}

	public static class ConfigNetherOres {

		@Config.LangKey(LANG + "enderOreGen")
		@Config.Comment({"Set to true to enable Ender Ore generation in the Nether."})
		public boolean netherEnderOreGen = false;

		@Config.LangKey(LANG + "enderOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Ender Ore in a chunk."})
		public int nEnderOreChance = 15;

		@Config.LangKey(LANG + "enderOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Ender Ore will spawn."})
		public int nEnderOreMinY = 60;

		@Config.LangKey(LANG + "enderOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Ender Ore will spawn."})
		public int nEnderOreMaxY = 90;

		@Config.LangKey(LANG + "enderOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int nEnderOreMinVein = 6;

		@Config.LangKey(LANG + "enderOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int nEnderOreMaxVein = 8;

		@Config.LangKey(LANG + "platinumOreGen")
		@Config.Comment({"Set to false to disable Platinum Ore generation in the Nether."})
		public boolean netherPlatinumOreGen = true;

		@Config.LangKey(LANG + "platinumOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Platinum Ore in a chunk."})
		public int nPlatinumOreChance = 8;

		@Config.LangKey(LANG + "platinumOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Platinum Ore will spawn."})
		public int nPlatinumOreMinY = 70;

		@Config.LangKey(LANG + "platinumOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Platinum Ore will spawn."})
		public int nPlatinumOreMaxY = 90;

		@Config.LangKey(LANG + "platinumOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int nPlatinumOreMinVein = 2;

		@Config.LangKey(LANG + "platinumOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int nPlatinumOreMaxVein = 3;
	}

	public static class ConfigEndOres {

		@Config.LangKey(LANG + "enderOreGen")
		@Config.Comment({"Set to false to disable Ender Ore generation in The End."})
		public boolean endEnderOreGen = true;

		@Config.LangKey(LANG + "enderOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Ender Ore in a chunk."})
		public int eEnderOreChance = 20;

		@Config.LangKey(LANG + "enderOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Ender Ore will spawn."})
		public int eEnderOreMinY = 1;

		@Config.LangKey(LANG + "enderOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Ender Ore will spawn."})
		public int eEnderOreMaxY = 60;

		@Config.LangKey(LANG + "enderOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int eEnderOreMinVein = 8;

		@Config.LangKey(LANG + "enderOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int eEnderOreMaxVein = 10;

		@Config.LangKey(LANG + "platinumOreGen")
		@Config.Comment({"Set to false to disable Platinum Ore generation in the Nether."})
		public boolean endPlatinumOreGen = true;

		@Config.LangKey(LANG + "platinumOreChance")
		@Config.RangeInt(min = 0, max = 40)
		@Config.Comment({"Chance to spawn Platinum Ore in a chunk."})
		public int ePlatinumOreChance = 13;

		@Config.LangKey(LANG + "platinumOreMinY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Minimum height that Platinum Ore will spawn."})
		public int ePlatinumOreMinY = 1;

		@Config.LangKey(LANG + "platinumOreMaxY")
		@Config.RangeInt(min = 0, max = 255)
		@Config.Comment({"Maximum height that Platinum Ore will spawn."})
		public int ePlatinumOreMaxY = 45;

		@Config.LangKey(LANG + "platinumOreMinVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Minimum number of blocks to spawn in a cluster/vein."})
		public int ePlatinumOreMinVein = 1;

		@Config.LangKey(LANG + "platinumOreMaxVein")
		@Config.RangeInt(min = 1, max = 50)
		@Config.Comment({"Maximum number of blocks to spawn in a cluster/vein."})
		public int ePlatinumOreMaxVein = 4;
	}

	public static class ConfigMisc {

		@Config.LangKey(LANG + "divineHammer")
		@Config.Comment({"Set to true to disable the Divine Hammer's attack. (Disables the smite not the actual items."})
		public boolean divineHammerAttackDisabled = false;

		@Config.LangKey(LANG + "smiteFail")
		@Config.RangeInt(min = 2, max = 100)
		@Config.Comment({"Sets the failure chance when right clicking the Divine Hammer."})
		public int smiteFail = 6;
		//TODO Move these to Proxys Lib.
		@Config.LangKey(LANG + "smiteRange")
		@Config.RangeInt(min = 1, max = 320)
		@Config.Comment({"Sets the maximum range the Divine Hammer can smite."})
		public int smiteRange = 130;

		@Config.LangKey(LANG + "fakePlayerSpawnEnderman")
		@Config.Comment({"Set to false to disable Enderman spawning when Ender Ore is mined by a fake player."})
		public boolean fakePlayerSpawnEnderman = true;

		@Config.LangKey(LANG + "endermanSpawn")
		@Config.Comment({"Enderman spawn chance in decimals for when Ender Ore is mined."})
		@Config.RangeDouble(min = 0.0, max = 1.0)
		public double endermanSpawn = 0.50;
	}
}
