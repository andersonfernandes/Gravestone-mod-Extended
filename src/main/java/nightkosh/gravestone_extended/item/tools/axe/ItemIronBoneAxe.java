package nightkosh.gravestone_extended.item.tools.axe;

import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemIronBoneAxe extends ItemBoneAxe {

    public ItemIronBoneAxe() {
        super(ToolMaterial.IRON);
        this.setUnlocalizedName("gravestone.bone_axe_iron");
        this.setRegistryName(ModInfo.ID, "gs_bone_axe_iron");
    }
}
