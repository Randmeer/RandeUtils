package tv.rande.randeutils.GUIs;

import tv.rande.randeutils.ChallengeBooleans;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ChallengeGUI implements CommandExecutor {

    public void doChallenge(CommandSender sender) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory menu = Bukkit.createInventory(player, 45, "Challenge Settings");

            ItemStack nochallenge = new ItemStack(Material.GRASS_BLOCK);
            ItemMeta nochallenge_meta = nochallenge.getItemMeta();
            nochallenge_meta.setDisplayName(ChatColor.WHITE + "No Challenge");
            ArrayList<String> nochallenge_lore = new ArrayList<>();
            nochallenge_lore.add(ChatColor.GRAY + "Plain Minecraft :)");
            nochallenge_meta.setLore(nochallenge_lore);
            nochallenge.setItemMeta(nochallenge_meta);
            menu.setItem(10, nochallenge);

            ItemStack gravitychallenge = new ItemStack(Material.SAND);
            ItemMeta gravitychallenge_meta = gravitychallenge.getItemMeta();
            gravitychallenge_meta.setDisplayName(ChatColor.WHITE + "Gravity Challenge");
            ArrayList<String> gravitychallenge_lore = new ArrayList<>();
            gravitychallenge_lore.add(ChatColor.GRAY + "All Blocks have Gravity");
            gravitychallenge.setItemMeta(gravitychallenge_meta);
            gravitychallenge_meta.setLore(gravitychallenge_lore);
            menu.setItem(11, gravitychallenge);

            ItemStack randommobchallenge = new ItemStack(Material.SPAWNER);
            ItemMeta randommobchallenge_meta = randommobchallenge.getItemMeta();
            randommobchallenge_meta.setDisplayName(ChatColor.WHITE + "Random Mob Challenge");
            ArrayList<String> randommobchallenge_lore = new ArrayList<>();
            randommobchallenge_lore.add(ChatColor.GRAY + "Mining Blocks spawns random Mobs");
            randommobchallenge.setItemMeta(randommobchallenge_meta);
            randommobchallenge_meta.setLore(randommobchallenge_lore);
            menu.setItem(12, randommobchallenge);


            //PLAINMC STATUS PANE
            Material plainmcstatuspane;
            String plainmcstatusname;
            ChatColor plainmcstatuscolor;
            String plainmcstatuslore;

            if (ChallengeBooleans.PlainMC) {
                plainmcstatuspane = Material.GREEN_STAINED_GLASS_PANE;
            }
            else {
                plainmcstatuspane = Material.RED_STAINED_GLASS_PANE;
            }

            if (ChallengeBooleans.PlainMC) {
                plainmcstatusname = "Active";
            }
            else {
                plainmcstatusname = "Not Aktive";
            }

            if (ChallengeBooleans.PlainMC) {
                plainmcstatuscolor = ChatColor.GREEN;
            }
            else {
                plainmcstatuscolor = ChatColor.RED;
            }

            if (ChallengeBooleans.PlainMC) {
                plainmcstatuslore = "Plain Minecraft is activated!";
            }
            else {
                plainmcstatuslore = "Click on the Grassblock to activate Plain Minecraft";
            }

            ItemStack plainmcstatus = new ItemStack(plainmcstatuspane);
            ItemMeta plainmcstatus_meta = plainmcstatus.getItemMeta();
            plainmcstatus_meta.setDisplayName(plainmcstatuscolor + plainmcstatusname);
            ArrayList<String> plainmcstatus_lore = new ArrayList<>();
            plainmcstatus_lore.add(ChatColor.GRAY + plainmcstatuslore);
            plainmcstatus_meta.setLore(plainmcstatus_lore);
            plainmcstatus.setItemMeta(plainmcstatus_meta);
            menu.setItem(19, plainmcstatus);


            //GRAVITYCHALLENGE STATUS PANE
            Material gravstatuspane;
            String gravstatusname;
            ChatColor gravstatuscolor;
            String gravstatuslore;

            if (ChallengeBooleans.GravityChallenge) {
                gravstatuspane = Material.GREEN_STAINED_GLASS_PANE;
            }
            else {
                gravstatuspane = Material.RED_STAINED_GLASS_PANE;
            }

            if (ChallengeBooleans.GravityChallenge) {
                gravstatusname = "Active";
            }
            else {
                gravstatusname = "Not Active";
            }

            if (ChallengeBooleans.GravityChallenge) {
                gravstatuscolor = ChatColor.GREEN;
            }
            else {
                gravstatuscolor = ChatColor.RED;
            }

            if (ChallengeBooleans.GravityChallenge) {
                gravstatuslore = "Gravity-Challenge is activated!";
            }
            else {
                gravstatuslore = "Click on the Sand to activate the Gravity-Challenge";
            }

            ItemStack gravstatus = new ItemStack(gravstatuspane);
            ItemMeta gravstatus_meta = gravstatus.getItemMeta();
            gravstatus_meta.setDisplayName(gravstatuscolor + gravstatusname);
            ArrayList<String> gravstatus_lore = new ArrayList<>();
            gravstatus_lore.add(ChatColor.GRAY + gravstatuslore);
            gravstatus_meta.setLore(gravstatus_lore);
            gravstatus.setItemMeta(gravstatus_meta);
            menu.setItem(20, gravstatus);


            //RANDOMMOBCHALLENGE STATUS PANE

            Material mobstatuspane;
            String mobstatusname;
            ChatColor mobstatuscolor;
            String mobstatuslore;

            if (ChallengeBooleans.RandomMobChallenge) {
                mobstatuspane = Material.GREEN_STAINED_GLASS_PANE;
            }
            else {
                mobstatuspane = Material.RED_STAINED_GLASS_PANE;
            }

            if (ChallengeBooleans.RandomMobChallenge) {
                mobstatusname = "Active";
            }
            else {
                mobstatusname = "Not Active";
            }

            if (ChallengeBooleans.RandomMobChallenge) {
                mobstatuscolor = ChatColor.GREEN;
            }
            else {
                mobstatuscolor = ChatColor.RED;
            }

            if (ChallengeBooleans.RandomMobChallenge) {
                mobstatuslore = "Random-Mob-Challenge is activated!";
            }
            else {
                mobstatuslore = "Click on the Spawner to activate the Random-Mob-Challenge.";
            }

            ItemStack mobstatus = new ItemStack(mobstatuspane);
            ItemMeta mobstatus_meta = mobstatus.getItemMeta();
            mobstatus_meta.setDisplayName(mobstatuscolor + mobstatusname);
            ArrayList<String> mobstatus_lore = new ArrayList<>();
            mobstatus_lore.add(ChatColor.GRAY + mobstatuslore);
            mobstatus_meta.setLore(mobstatus_lore);
            mobstatus.setItemMeta(mobstatus_meta);
            menu.setItem(21, mobstatus);

            //ItemStack profile = new ItemStack(Material.NAME_TAG);
            //ItemMeta profile_meta = profile.getItemMeta();
            //profile_meta.setDisplayName(ChatColor.GREEN + "Your Profile");
            //ArrayList<String> profile_lore = new ArrayList<>();
            //profile_lore.add(ChatColor.GRAY + "Opens" + player.getName() + "'s AquaGames Profile");
            //profile_meta.setLore(profile_lore;
            //profile.setItemMeta(profile_meta);
            //menu.setItem(32, profile);

            player.openInventory(menu);

//          player.sendMessage(Main.getRndPrefix() + ChatColor.GOLD + "Challenge-Settings opened");
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        doChallenge(sender);

        return true;
    }
}
