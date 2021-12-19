package tv.rande.randeutils.commands;

import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Some useful commands:\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /date\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /info\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /help\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /timer resume\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /timer pause\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /timer settings\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /challenge info\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /challenge settings\n"
                + ChatColor.DARK_AQUA + ">>" + ChatColor.GRAY + " /rndebug");
        return false;
    }
}
