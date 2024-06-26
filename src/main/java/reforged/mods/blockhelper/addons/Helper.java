package reforged.mods.blockhelper.addons;

import ic2.core.util.StackUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import reforged.mods.blockhelper.addons.i18n.I18n;

public class Helper {

    public static String getTierForDisplay(int tier) {
        switch (tier) {
            case 0:
                return I18n.format("info.tier.ulv");
            case 1:
                return I18n.format("info.tier.lv");
            case 2:
                return I18n.format("info.tier.mv");
            case 3:
                return I18n.format("info.tier.hv");
            case 4:
                return I18n.format("info.tier.ev");
            case 5:
                return I18n.format("info.tier.iv");
            case 6:
                return I18n.format("info.tier.luv");
            case 7:
                return I18n.format("info.tier.zpm");
            case 8:
                return I18n.format("info.tier.uv");
            case 9:
                return I18n.format("info.tier.uhv");
            case 10:
                return I18n.format("info.tier.uev");
            case 11:
                return I18n.format("info.tier.uiv");
            case 12:
                return I18n.format("info.tier.umv");
            case 13:
                return I18n.format("info.tier.uxv");
            case 14:
                return I18n.format("info.tier.max");
            default:
                return TextColor.RED.format("ERROR, please report!");
        }
    }

    public static int getTierFromEU(int value) {
        return value <= 8 ? 0 : (int)Math.ceil(Math.log((double)value * 0.125) * (1.0 / Math.log(4.0)));
    }

    public static int getMaxInputFromTier(int tier) {
        switch (tier) {
            case 1:
                return 32;
            case 2:
                return 128;
            case 3:
                return 3;
            case 4:
                return 2048;
            case 5:
                return 8192;
            case 6:
                return 32768;
            default:
                return 0;
        }
    }

    public static String getTextColor(int value) {
        String colorCode = "f"; // white
        if (value >= 90) {
            colorCode = "a"; // green
        }
        if ((value <= 90) && (value > 75)) {
            colorCode = "e"; // yellow
        }
        if ((value <= 75) && (value > 50)) {
            colorCode = "6"; // gold
        }
        if ((value <= 50) && (value > 35)) {
            colorCode = "c"; // red
        }
        if (value <= 35) {
            colorCode = "4"; // dark_red
        }

        return "\247" + colorCode;
    }

    public static boolean hasHotbarItems(EntityPlayer player, ItemStack filter) {
        if (player != null) {
            InventoryPlayer inv = player.inventory;
            for (int i = 0; i < 9; ++i) {
                ItemStack hotbarStack = inv.getStackInSlot(i);
                if (StackUtil.isStackEqual(hotbarStack, filter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
