package rpg.enums;

import net.minecraft.item.Item;
import rpg.config.RPGItems;
import rpg.items.armor.ItemRPGArmor;

public enum EnumRPGArmorMaterial {
    TRAINING(1, new int[] { 1, 1, 1, 1 }, 1), TAURITE(1,
            new int[] { 1, 1, 1, 1 }, 1);

    /**
     * Holds the maximum damage factor (each piece multiply this by it's own value) of the material, this is the item
     * damage (how much can absorb before breaks)
     */
    private int maxDamageFactor;

    /**
     * Holds the damage reduction (each 1 points is half a shield on gui) of each piece of armor (helmet, plate, legs
     * and boots)
     */
    private int[] damageReductionAmountArray;

    /** Return the enchantability factor of the material */
    private int enchantability;

    // Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumRPGArmorMaterial(int par3, int[] par4ArrayOfInteger, int par5) {
        this.maxDamageFactor = par3;
        this.damageReductionAmountArray = par4ArrayOfInteger;
        this.enchantability = par5;
    }

    /**
     * Return the crafting material for this armor material, used to determine the item that can be used to repair a
     * piece of armor with an anvil
     */
    public int getArmorCraftingMaterial() {
        switch (this) {
        case TAURITE:
            return RPGItems.taurite.itemID;
        default:
            return (customCraftingMaterial == null ? 0
                    : customCraftingMaterial.itemID);
        }
    }

    /**
     * Return the damage reduction (each 1 point is a half a shield on gui) of the piece index passed (0 = helmet, 1 =
     * plate, 2 = legs and 3 = boots)
     */
    public int getDamageReductionAmount(int par1) {
        return this.damageReductionAmountArray[par1];
    }

    /**
     * Returns the durability for a armor slot of for this type.
     */
    public int getDurability(int par1) {
        return ItemRPGArmor.getMaxDamageArray()[par1] * this.maxDamageFactor;
    }

    /**
     * Return the enchantability factor of the material.
     */
    public int getEnchantability() {
        return this.enchantability;
    }
}
