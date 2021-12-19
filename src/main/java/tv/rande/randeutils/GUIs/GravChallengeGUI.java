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

public class GravChallengeGUI implements CommandExecutor {

    public void doGravChallenge(CommandSender sender) {

        if (sender instanceof Player) {

            // TODO

            Player player = (Player) sender;
            Inventory menu = Bukkit.createInventory(player, 27, "GravityChallenge Settings");
            player.openInventory(menu);

        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        doGravChallenge(sender);

        return true;
    }
}
