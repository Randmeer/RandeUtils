package tv.rande.randeutils.listeners;

import tv.rande.randeutils.Main;
import tv.rande.randeutils.ChallengeBooleans;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class MovementListener implements Listener {

    public final int radius = 5;

    @EventHandler
    public void onPlayMove(PlayerMoveEvent event) {

        if (ChallengeBooleans.GravityChallenge) {

            Player player = event.getPlayer();
            int max_X = player.getLocation().getBlockX() + radius;
            int max_Z = player.getLocation().getBlockZ() + radius;
            int min_X = player.getLocation().getBlockX() - radius;
            int min_Z = player.getLocation().getBlockZ() - radius;

            new BukkitRunnable() { // Creates a new thread that runs on the next tic.

                @Override
                public void run() {
                    for (int i = min_X; i < max_X; i++) { // Go through all blocks within the radius of the player and
                        // update them if they have air beneath them.
                        for (int j = 0; j < 256; j++) {
                            for (int k = min_Z; k < max_Z; k++) {
                                Location loc = new Location(player.getWorld(), i + 0.5, j, k + 0.5);
                                Block fallingBlock = loc.getBlock();
                                if (allowedTypes(fallingBlock) && airUnderBlock(loc)) {
                                    BlockData data = fallingBlock.getBlockData();
                                    fallingBlock.setType(Material.AIR); // Deletes the block
                                    player.getWorld().spawnFallingBlock(loc, data); // creates new falling block of the previous type
                                }
                            }
                        }
                    }

                }
            }.runTask(Main.getPlugin(Main.class));
        }
    }

    public boolean airUnderBlock(Location loc) {
        Location temp = new Location(loc.getWorld(), loc.getX(), loc.getY() -1, loc.getZ());
        if ((temp.getBlock().getType() == Material.AIR) || (temp.getBlock().getType() == Material.WATER) || (temp.getBlock().getType() == Material.LAVA) || (temp.getBlock().getType() == Material.CAVE_AIR) || (temp.getBlock().getType() == Material.VOID_AIR)) {
            return true;
        }
        else {
            return false;
        }
    }

    // didn't bother adding all the concrete powders, nobody uses them anyway
    public boolean allowedTypes(Block block) {
        if ((block.getType() != Material.AIR) && (block.getType() != Material.BEDROCK) && (block.getType() != Material.OBSIDIAN) &&
            (block.getType() != Material.END_PORTAL_FRAME) && (block.getType() != Material.END_PORTAL) && (block.getType() != Material.WATER) &&
            (block.getType() != Material.LAVA) && (block.getType() != Material.SAND) && (block.getType() != Material.GRAVEL) &&
            (block.getType() != Material.ANVIL) && (block.getType() != Material.RED_SAND) &&
            (block.getType() != Material.CHIPPED_ANVIL) && (block.getType() != Material.DAMAGED_ANVIL)) {
            return true;
        }
        else {
            return false;
        }
    }

    //https://github.com/rdiaz002/FallingBlocks-Minecraft-Plugin/blob/master/src/main/java/com/github/rdiaz002/fallingPlugs/fallingPlugs.java
    //genius
}