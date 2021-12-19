package tv.rande.randeutils.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RandeModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.getName().equals("Das_Randmeer")) {
            sender.sendMessage("Welcome back, Rande");
        }
        else {
            sender.sendMessage("access denied");
        }
        return false;
    }
}
