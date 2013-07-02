package rpg.items.archer.weapons;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import rpg.client.entities.projectiles.EntityArrowTraining;
import rpg.config.base.archer.ArcherWeapons;
import rpg.items.RPGItem;
import rpg.lib.Reference;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGBow extends RPGItem {

	public ItemRPGBow(int par1, String name) {
		super(par1, name);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
		PlayerInformation playerInfo = PlayerInformation.forPlayer(player);
		// Checks the players class and colored item name
		// accordingly
		if (playerInfo.getPlayersClass().equals("Archer") && player.experienceLevel >= 1) {
			par3List.add("Class: \u00a7AArcher");
			par3List.add("Level: \u00a7A1");
		} else if (playerInfo.getPlayersClass().equals("Archer") && player.experienceLevel != 1) {
			par3List.add("Class: \u00a7AArcher");
			par3List.add("Level: \u00a741");
		} else if (!playerInfo.getPlayersClass().equals("Archer") && player.experienceLevel == 1) {
			par3List.add("Class: \u00a74Archer");
			par3List.add("Level: \u00a7A1");
		} else {
			par3List.add("Class: \u00a74Archer");
			par3List.add("Level: \u00a741");
		}
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability() {
		return 1;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		PlayerInformation playerInfo = PlayerInformation.forPlayer(par3EntityPlayer);
		if (playerInfo.getPlayersClass().equals("Archer")) {
			ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
			MinecraftForge.EVENT_BUS.post(event);
			if (event.isCanceled())
				return event.result;

			if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(ArcherWeapons.arrowTraining.itemID)) {
				par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			}
		} else {
			if (playerInfo.getShouldUseMysteriousVoice())
				par3EntityPlayer.sendChatToPlayer("\u00a74<Mysterious Voice> Do not try to use the power of a weapon that is not meant for you!");
			else
				par3EntityPlayer.sendChatToPlayer("\u00a74<Dagon> Do not try to use the power of a weapon that is not meant for you!");
		}

		return par1ItemStack;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
			return;
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(ArcherWeapons.arrowTraining.itemID)) {
			float f = j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if (f < 0.1D)
				return;

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityArrowTraining entityarrow = new EntityArrowTraining(par2World, par3EntityPlayer, f * 2.0F);

			if (f == 1.0F) {
				entityarrow.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

			if (k > 0) {
				entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

			if (l > 0) {
				entityarrow.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
				entityarrow.setFire(100);
			}

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				entityarrow.canBePickedUp = 2;
			} else {
				par3EntityPlayer.inventory.consumeInventoryItem(ArcherWeapons.arrowTraining.itemID);
			}

			if (!par2World.isRemote) {
				// entityarrow.setPosition(par3EntityPlayer.posX, par3EntityPlayer.posY + 3, par3EntityPlayer.posZ);
				par2World.spawnEntityInWorld(entityarrow);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private Icon[] bowIcons = new Icon[4];

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconreg) {
		this.itemIcon = iconreg.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
		
		for (int i = 1; i < this.bowIcons.length; i++)
			this.bowIcons[i] = iconreg.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_pull_" + (i - 1));
	}

	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if(player.getItemInUse() == null) return this.itemIcon;
		int time = stack.getMaxItemUseDuration() - useRemaining;
		if (time >= 18)
			return bowIcons[3];
		else if (time > 13)
			return bowIcons[2];
		else if (time > 0)
			return bowIcons[1];
		
		return bowIcons[0];
	}
}