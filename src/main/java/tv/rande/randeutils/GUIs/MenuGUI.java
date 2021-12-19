package tv.rande.randeutils.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuGUI implements CommandExecutor {

    public void doMenu(CommandSender sender) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Inventory menu = Bukkit.createInventory(player, 27, "RandeUtils Menu");

            //ItemStack profile = new ItemStack(Material.NAME_TAG);
            //ItemMeta profile_meta = profile.getItemMeta();
            //profile_meta.setDisplayName(ChatColor.GREEN + "Your Profile");
            //ArrayList<String> profile_lore = new ArrayList<>();
            //profile_lore.add(ChatColor.GRAY + "Opens" + player.getName() + "'s AquaGames Profile");
            //profile_meta.setLore(profile_lore;
            //profile.setItemMeta(profile_meta);
            //menu.setItem(32, profile);

            player.openInventory(menu);

        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        doMenu(sender);

        return true;
    }
}
