package tv.rande.randeutils.commands;

import tv.rande.randeutils.ChallengeBooleans;
import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class DateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Date date = new Date();
        sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Date: " + date.toString());
        return false;
    }
}
