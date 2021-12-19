package tv.rande.randeutils.listeners;

import tv.rande.randeutils.ChallengeBooleans;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class SandFallListener implements Listener {

    @EventHandler
    public void onSandFall(EntityChangeBlockEvent event) {

        if (ChallengeBooleans.GravityChallenge) {
            if (event.getEntityType() == EntityType.FALLING_BLOCK && event.getTo() == Material.AIR) {
                if ((event.getBlock().getType() == Material.SAND) || (event.getBlock().getType() == Material.RED_SAND) ||
                        (event.getBlock().getType() == Material.GRAVEL) || (event.getBlock().getType() == Material.ANVIL) ||
                        (event.getBlock().getType() == Material.CHIPPED_ANVIL) || (event.getBlock().getType() == Material.DAMAGED_ANVIL)) {
                    event.setCancelled(true);
                    //Update the block to fix a visual client bug, but don't apply physics
                    event.getBlock().getState().update(false, false);
                }
            }
        }
    }
}
