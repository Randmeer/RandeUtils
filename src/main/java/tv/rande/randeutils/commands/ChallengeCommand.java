package tv.rande.randeutils.commands;

import tv.rande.randeutils.GUIs.ChallengeGUI;
import tv.rande.randeutils.ChallengeBooleans;
import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChallengeCommand implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0)
        {
            if (args[0].equalsIgnoreCase("info")) {
                sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Information about the selected Challenge:" );
                sender.sendMessage(ChatColor.DARK_AQUA + ">> " + ChatColor.GRAY + "Active Challenge: " + ChallengeBooleans.getCurrentChallenge);
                sender.sendMessage(ChatColor.DARK_AQUA + ">> " + ChatColor.GRAY +  ChallengeBooleans.getCurrentChallengeInformation);
                return true;
            }
            else if (args[0].equalsIgnoreCase("settings")) {
                ChallengeGUI challenge = Main.getMyChallenge();
                challenge.doChallenge(sender);
                return true;
            }
            else {
                sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Haha typo");
                return false;
            }
        }
        else {
            sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Please use /challenge info or /challenge settings");
            return true;
        }

    }
}

