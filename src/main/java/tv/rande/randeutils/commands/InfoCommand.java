package tv.rande.randeutils.commands;

import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Information:\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " You are playing on [server name]\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " Server-Owner: [owner name]\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " Server-Staff: [staff name], [another staff name]\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " Commands: /date, /info, /timer, /challenge\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " Plugin: RandeUtils by Das_Randmeer");
        return false;
    }
}
