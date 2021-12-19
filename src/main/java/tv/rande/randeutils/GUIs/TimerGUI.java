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

public class TimerGUI implements CommandExecutor {

    public void doMenu(CommandSender sender) {

        if (sender instanceof Player) {

            // TODO

            Player player = (Player) sender;

            Inventory menu = Bukkit.createInventory(player, 27, "Timer Settings");

            ItemStack stopwatch = new ItemStack(Material.CLOCK);
            ItemMeta stopwatch_meta = stopwatch.getItemMeta();
            stopwatch_meta.setDisplayName(ChatColor.RED + "Stopwatch");
            ArrayList<String> stopwatch_lore = new ArrayList<>();
            stopwatch_lore.add(ChatColor.GRAY + "Sets Timer-Mode to Stopwatch");
            stopwatch_meta.setLore(stopwatch_lore);
            stopwatch.setItemMeta(stopwatch_meta);
            menu.setItem(10, stopwatch);

            ItemStack timer = new ItemStack(Material.COMPASS);
            ItemMeta timer_meta = timer.getItemMeta();
            timer_meta.setDisplayName(ChatColor.GREEN + "Timer");
            ArrayList<String> timer_lore = new ArrayList<>();
            timer_lore.add(ChatColor.GRAY + "Sets Timer-Mode to Timer");
            timer_meta.setLore(timer_lore);
            timer.setItemMeta(timer_meta);
            menu.setItem(12, timer);

            //ItemStack profile = new ItemStack(Material.NAME_TAG);
            //ItemMeta profile_meta = profile.getItemMeta();
            //profile_meta.setDisplayName(ChatColor.GREEN + "Your Profile");
            //ArrayList<String> profile_lore = new ArrayList<>();
            //profile_lore.add(ChatColor.GRAY + "Opens" + player.getName() + "'s AquaGames Profile");
            //profile_meta.setLore(profile_lore;
            //profile.setItemMeta(profile_meta);
            //menu.setItem(32, profile);

            player.openInventory(menu);

            //player.sendMessage(Main.getRndPrefix() + ChatColor.GOLD + "Timer-Settings opened");
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        doMenu(sender);

        return true;
    }
}
