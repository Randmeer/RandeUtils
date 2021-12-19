package tv.rande.randeutils.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(player.getDisplayName().equals("Das_Randmeer")) {
            event.setFormat(ChatColor.AQUA + "<%1$s>" + ChatColor.WHITE + " %2$s");
        }
        else if(player.isOp()){
            event.setFormat(ChatColor.DARK_AQUA + "<%1$s>" + ChatColor.WHITE + " %2$s");
        }
        else{
            event.setFormat(ChatColor.DARK_GRAY + "<%1$s>" + ChatColor.GRAY + " %2$s");
        }
        event.setMessage(player.isOp() ? ChatColor.translateAlternateColorCodes( '&', event.getMessage()) : event.getMessage());
    }
}
