package tv.rande.randeutils.commands;

import tv.rande.randeutils.ChallengeBooleans;
import tv.rande.randeutils.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RNDebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Debug-Information:\n");
        sender.sendMessage(ChatColor.GRAY + "PlainMC: " + ChallengeBooleans.PlainMC);
        sender.sendMessage(ChatColor.GRAY + "GravityChallenge: " + ChallengeBooleans.GravityChallenge);
        sender.sendMessage(ChatColor.GRAY + "RandomMobChallenge: " + ChallengeBooleans.RandomMobChallenge);
        sender.sendMessage(ChatColor.GRAY + "Aktive Challenge: " + ChallengeBooleans.getCurrentChallenge);
        sender.sendMessage(ChatColor.GRAY + "Challenge Info: " + ChallengeBooleans.getCurrentChallengeInformation);
        return false;
    }
}
