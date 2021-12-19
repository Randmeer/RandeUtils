package tv.rande.randeutils.listeners;

import tv.rande.randeutils.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        //player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 65, 0.5));
        player.sendMessage(Main.getRndPrefix() + ChatColor.GOLD + "Hi, " + player.getName() + ", welcome!");
        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "RandeUtils version 0.4 by Rande :)");
        event.setJoinMessage(ChatColor.GREEN + ">> " + ChatColor.WHITE + player.getName());
        Location loc = player.getLocation();
        player.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 3.0F, 0.5F);

        //factory reset player
        //player.setFoodLevel(20);
        //player.setHealth(20);
        //player.setLevel(0);
        //player.setExp(0);
        //player.setTotalExperience(0);
        //player.setGameMode(GameMode.ADVENTURE);
        //Inventory inv = player.getInventory();
        //inv.clear();


        //set players inventory

        //ItemStack compass = new ItemStack(Material.COMPASS);
        //ItemMeta compass_meta = compass.getItemMeta();
        //compass_meta.setDisplayName(ChatColor.AQUA + "Game Menu");
        //ArrayList<String> compass_lore = new ArrayList<>();
        //compass_lore.add(ChatColor.GRAY + "Right click to open");
        //compass_meta.setLore(compass_lore);
        //compass.setItemMeta(compass_meta);

        //player.getInventory().setItem(0, compass);

        //ItemStack profile = new ItemStack(Material.PLAYER_HEAD);
        //SkullMeta profile_meta = (SkullMeta) profile.getItemMeta();
        //profile_meta.setDisplayName(ChatColor.AQUA + "Your Profile");
        //ArrayList<String> profile_lore = new ArrayList<>();
        //profile_lore.add(ChatColor.GRAY + "Opens " + player.getName() + "'s 303-Server Profile");
        //profile_meta.setLore(profile_lore);
        //profile_meta.setOwner(player.getName());
        //profile.setItemMeta(profile_meta);

        //player.getInventory().setItem(4, profile);

        //ItemStack settings = new ItemStack(Material.IRON_PICKAXE);
        //ItemMeta settings_meta = settings.getItemMeta();
        //settings_meta.setDisplayName(ChatColor.AQUA + "Settings");
        //ArrayList<String> settings_lore = new ArrayList<>();
        //settings_lore.add(ChatColor.GRAY + "Right click to open");
        //settings_meta.setLore(settings_lore);
        //settings.setItemMeta(settings_meta);

        //player.getInventory().setItem(8, settings);

    }
}