package rpg;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import rpg.lib.Reference;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

public final class MinePGUtil {

	private static final String ENTITY_DATA = Reference.MOD_ID;
	public static final String PARTICLE_TEXTURE_FILE = "/mods/" + Reference.MOD_ID + "/textures/particles.png";
	public static final String EVENT_HANDLER = Reference.MOD_ID + "/handlers/event/KarmaEventHandler";

	private MinePGUtil() { }

	public static NBTTagCompound getEntityData(Entity entity) {
		NBTTagCompound persistentData;

		if (entity instanceof EntityPlayer) {
			NBTTagCompound entityData = entity.getEntityData();
			persistentData = getCompound(entityData, EntityPlayer.PERSISTED_NBT_TAG);
		} else {
			persistentData = entity.getEntityData();
		}
		return getCompound(persistentData, ENTITY_DATA);
	}

	public static NBTTagCompound getCompound(NBTTagCompound parent, String key) {
		if (!parent.hasKey(key)) {
			parent.setCompoundTag(key, new NBTTagCompound());
		}
		return parent.getCompoundTag(key);
	}

	public static ItemStack getItemStack(Object item) {
		if (item instanceof Item) {
			return new ItemStack((Item)item);
		} else if (item instanceof Block) {
			return new ItemStack((Block)item);
		} else if (item instanceof ItemStack) {
			return (ItemStack)item;
		} else {
			return new ItemStack(Block.stone);
		}
	}

	public static ItemStack[] getItemStacks(Object... items) {
		ItemStack[] stacks = new ItemStack[items.length];
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = getItemStack(items[i]);
		}
		return stacks;
	}

	public static String capitalize(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static String getChatMessage(String string) {
		return EnumChatFormatting.DARK_GREEN + "[MinePG] " + EnumChatFormatting.RESET;
	}

	public static AbstractInsnNode findLastReturn(InsnList insns) {
		return findLast(insns, Opcodes.RETURN);
	}

	public static AbstractInsnNode findLast(InsnList insns, int opcode) {
		for (int i = insns.size() - 1; i >= 0; i--) {
			AbstractInsnNode insn = insns.get(i);
			if (insn.getOpcode() == opcode) {
				return insn;
			}
		}
		return null;
	}

	private static Field[] fields = Opcodes.class.getDeclaredFields();

	public static String getOpcodeName(int opcode) {
		for (int i = 57; i < fields.length; i++) {
			Field field = fields[i];
			try {
				if (field.getType() == int.class && field.getInt(null) == opcode) {
					return field.getName();
				}
			} catch (Exception e) { //ReflectiveOperationException e
				return "missingno";
			}
		}
		return "missingno";
	}

	private static Field[] fields2 = AbstractInsnNode.class.getDeclaredFields();

	public static String getInsnNodeType(int type) {
		for (int i = 0; i < fields2.length; i++) {
			Field field = fields2[i];
			try {
				if (field.getType() == int.class && field.getInt(null) == type) {
					return field.getName();
				}
			} catch (Exception e) { //ReflectiveOperationException e
				return "missingno";
			}
		}
		return "missingno";
	}
}
