package tv.rande.randeutils.commands;

import tv.rande.randeutils.GUIs.TimerGUI;
import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerCommand implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0)
        {
            if (args[0].equalsIgnoreCase("resume"))
            {
                sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Timer resumed");
                return true;
            }
            else if (args[0].equalsIgnoreCase("pause"))
            {
                sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Timer paused");
                return true;
            }
            else if (args[0].equalsIgnoreCase("settings"))
            {
                TimerGUI timer = Main.getMyTimer();
                timer.doMenu(sender);
                return true;
            }
            else {
                sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Haha typo");
                return false;
            }
        }
        else
        {
            sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Please use /timer resume, /timer pause or /timer settings");
            return true;
        }
    }
}

