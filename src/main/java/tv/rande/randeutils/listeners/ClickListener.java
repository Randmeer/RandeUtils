package tv.rande.randeutils.listeners;

import tv.rande.randeutils.GUIs.ChallengeGUI;
import tv.rande.randeutils.GUIs.GravChallengeGUI;
import tv.rande.randeutils.GUIs.MenuGUI;
import tv.rande.randeutils.GUIs.TimerGUI;
import tv.rande.randeutils.Main;
import tv.rande.randeutils.ChallengeBooleans;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickListener implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        MenuGUI menu = Main.getMyMenu();
        TimerGUI timer = Main.getMyTimer();
        ChallengeGUI challenge = Main.getMyChallenge();
        GravChallengeGUI gravChallenge = Main.getMyGravChallenge();

        if (e.getCurrentItem() == null) {
            return;
        }

        ClickType clicktype = e.getClick();

        if (clicktype.isLeftClick() || clicktype.isRightClick()) {


            // MENU:
            if (e.getView().getTitle().equalsIgnoreCase("RandeUtils Menu")) {
                switch (e.getCurrentItem().getType()) {
                    case DARK_OAK_DOOR:
                        player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 65, 0.5));
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Warped to the Main Hub");
                        ChallengeBooleans.getCurrentChallenge = "No Challenge selected!";
                        break;
                    case PLAYER_HEAD:
                        menu.doMenu(e.getWhoClicked());
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Opened Profile GUI");
                        ChallengeBooleans.getCurrentChallenge = "No Challenge selected!";
                        break;
                    case GRASS_BLOCK:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "This Gamemode currently isn't available");
                        ChallengeBooleans.getCurrentChallenge = "No Challenge selected!";
                }
            }

            //CHALLENGE SETTINGS:
            else if (e.getView().getTitle().equalsIgnoreCase("Challenge Settings")) {
                switch (e.getCurrentItem().getType()) {

                    case GRASS_BLOCK:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "No Challenge selected");
                        ChallengeBooleans.PlainMC = true;
                        ChallengeBooleans.GravityChallenge = false;
                        ChallengeBooleans.RandomMobChallenge = false;
                        ChallengeBooleans.getCurrentChallenge = "None";
                        ChallengeBooleans.getCurrentChallengeInformation = "Activate Challenges with /challenge settings";
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        challenge.doChallenge(e.getWhoClicked());
                        break;

                    case SAND:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Gravity-Challenge selected");
                        ChallengeBooleans.PlainMC = false;
                        ChallengeBooleans.GravityChallenge = true;
                        ChallengeBooleans.RandomMobChallenge = false;
                        ChallengeBooleans.getCurrentChallenge = "Gravity Challenge";
                        ChallengeBooleans.getCurrentChallengeInformation =
                                ("In this Challenge, all blocks in Minecraft \n" +
                                "have Gravity, just like Sand or Gravel.\n" +
                                "Block that were affected by gravity\n" +
                                "previously, now hover in the air!");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        challenge.doChallenge(e.getWhoClicked());
                        break;

                    case SPAWNER:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Random-Mob-Challenge selected");
                        ChallengeBooleans.PlainMC = false;
                        ChallengeBooleans.GravityChallenge = false;
                        ChallengeBooleans.RandomMobChallenge = true;
                        ChallengeBooleans.getCurrentChallenge = "Random Mob Challenge";
                        ChallengeBooleans.getCurrentChallengeInformation =
                                ("In this Challenge, Breaking a Block summons\n" +
                                 "a random hostile Mob in its place.\n" +
                                 "The Block still drops an Item, dont worry :)");
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        challenge.doChallenge(e.getWhoClicked());
                        break;
                }
            }

            //TIMER SETTINGS:
            else if (e.getView().getTitle().equalsIgnoreCase("Timer Settings")) {
                switch (e.getCurrentItem().getType()) {
                    case BARRIER:
                        player.closeInventory();
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Timer-Settings closed");
                        break;
                    case COMPASS:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Timer-Mode: Timer");
                        break;
                    case CLOCK:
                        player.sendMessage(Main.getRndPrefix() + ChatColor.GRAY + "Timer-Mode: Stopwatch");
                        break;
                }
            }

            //GRAV CHALLENGE SETTINGS
            else if (e.getView().getTitle().equalsIgnoreCase("GravityChallenge Settings")) {
                // TODO
            }
        }

        // in case you want the player move items in his inventory: (via: https://www.youtube.com/watch?v=qyEakJkQHIY )
        //if(e.getClickedInventory().getTitle().equalsIgnoreCase("Game Menu")) {
        //e.setCancelled(true);

        //switch (e.getCurrentItem().getType()) {'
        //    case COMPASS:
        //        menu.doMenu(e.getWhoClicked());
        //}

        //WE DON'T WANT TO LET PLAYERS MOVE ITEMS IN THE GUI'S, SO WE DO THIS
        if (e.getView().getTitle().equalsIgnoreCase("Menu")) {
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase("Timer Settings")) {
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase("Challenge Settings")) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }

    }
}
