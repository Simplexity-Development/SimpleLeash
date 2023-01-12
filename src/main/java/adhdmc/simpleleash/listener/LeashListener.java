package adhdmc.simpleleash.listener;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class LeashListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onLeashInteract(PlayerInteractEntityEvent event) {
        ItemStack handItem = event.getPlayer().getInventory().getItem(EquipmentSlot.HAND);
        if (handItem.getType() != Material.LEAD) return;
        if (!(event.getRightClicked() instanceof LivingEntity entity)) return;
        // TODO: Add configuration of settable living entities.
        // TODO: Add permissions checks.
        event.setCancelled(true);
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (entity.isLeashed() && entity.getLeashHolder() == event.getPlayer()) {
            entity.setLeashHolder(null);
            entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.LEAD, 1));
            return;
        }
        entity.setLeashHolder(event.getPlayer());
        handItem.subtract();
    }

}
