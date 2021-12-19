package tv.rande.randeutils.listeners;

import tv.rande.randeutils.ChallengeBooleans;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreakListener implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (ChallengeBooleans.RandomMobChallenge) {
            Location location = event.getBlock().getLocation();
            Location newlocation = new Location(location.getWorld(), location.getX() + 0.5, location.getY(), location.getZ() + 0.5);
            Player player = event.getPlayer();
            Random random = new Random();

            int[] hostiles = new int[]{4, 5, 6, 23, 27, 34, 35, 36, 37, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 66, 67, 68, 69, 28, 29, 31, 32, 65, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 120};
            int randomid = hostiles[random.nextInt(hostiles.length)];

            EntityType entitytype = EntityType.fromId(randomid);

            player.getWorld().spawnEntity(newlocation, entitytype);
        }
    }

}
