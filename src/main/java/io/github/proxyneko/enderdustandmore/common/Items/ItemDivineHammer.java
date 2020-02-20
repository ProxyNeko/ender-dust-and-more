package io.github.proxyneko.enderdustandmore.common.Items;

import io.github.proxyneko.enderdustandmore.init.ModConfig;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;

public class ItemDivineHammer extends Item {

	public ItemDivineHammer() {
		setMaxStackSize(1);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (!world.isRemote) {
			if (hand == EnumHand.MAIN_HAND) {
				Random rand = new Random();
				int configChance = ModConfig.miscConfig.smiteFail;
				int chance;
				int range = ModConfig.miscConfig.smiteRange;
				double x, y, z;

				if (ModConfig.miscConfig.divineHammerAttackDisabled) {
					player.sendMessage(new TextComponentTranslation("enderdustandmore.smite.disabled"));
				} else {
					if (configChance == 0) {
						chance = 1;
					} else {
						chance = rand.nextInt(configChance);
					}

					if (range < 1 || range > 320) {
						range = 128;
					}

					if (chance == 0) {
						player.sendMessage(new TextComponentTranslation("enderdustandmore.smite.msg"));
						x = player.posX;
						y = player.posY;
						z = player.posZ;
					} else {
						x = player.rayTrace(range, 1).getBlockPos().getX();
						y = player.rayTrace(range, 1).getBlockPos().getY();
						z = player.rayTrace(range, 1).getBlockPos().getZ();
					}

					if (!player.canPlayerEdit(new BlockPos(x, y, z), player.getHorizontalFacing(), itemstack)) {
						player.sendMessage(new TextComponentTranslation("enderdustandmore.smite.protect"));
					} else {
						world.spawnEntity(new EntityLightningBolt(world, x, y, z, false));
					}
				}
			}
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
	}
}