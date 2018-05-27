package nightkosh.gravestone_extended.item.armor.swamp_thing_costume;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.Resources;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemSwampThingBoots extends ItemArmor {

    public ItemSwampThingBoots() {
        super(ArmorMaterial.LEATHER, 1, EntityEquipmentSlot.FEET);
        this.setUnlocalizedName("gravestone.swamp_thing_boots");
        this.setRegistryName(ModInfo.ID, "gs_swamp_thing_boots");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return Resources.SWAMP_THING_BOOTS;
    }
}
