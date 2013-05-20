package rpg.enums.weapons;

import net.minecraft.item.Item;
import rpg.config.RPGItems;

public enum EnumRPGHammerMaterial {
    TRAINING(32, 1, 1), TAURITE(200, 5, 10);

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /** Damage versus entities. */
    private final int damageVsEntity;

    /**
     * Defines the natural enchantability factor of the material.
     */
    private final int enchantability;

    // Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumRPGHammerMaterial(int par3, int par4, int par5) {
        this.maxUses = par3;
        this.damageVsEntity = par4;
        this.enchantability = par5;
    }

    /**
     * Damage versus entities.
     */
    public int getDamageVsEntity() {
        return this.damageVsEntity;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability() {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getHammerCraftingMaterial() {
        switch (this) {
        case TAURITE:
            return RPGItems.taurite.itemID;
        default:
            return (customCraftingMaterial == null ? 0
                    : customCraftingMaterial.itemID);
        }
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses() {
        return this.maxUses;
    }
}
