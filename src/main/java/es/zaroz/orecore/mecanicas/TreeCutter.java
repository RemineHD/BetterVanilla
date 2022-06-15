package es.zaroz.orecore.mecanicas;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class TreeCutter implements Listener {
    
    
    @EventHandler
    public void breakingBlock(BlockBreakEvent blockBreakEvent) {

    if (blockBreakEvent.isCancelled())
        return;

    //TODO: Check here is player is usign the right tool
    
        switch (blockBreakEvent.getBlock().getType()) {
            case ACACIA_LOG:
            case BIRCH_LOG:
            case DARK_OAK_LOG:
            case JUNGLE_LOG:
            case OAK_LOG:
            case SPRUCE_LOG:
                breakBlock(blockBreakEvent.getBlock(), blockBreakEvent.getPlayer());
        }

    }

    public void breakBlock(Block block, Player player) {

        if (player.getGameMode() != GameMode.SURVIVAL)
            return;

        block.breakNaturally();
        Location above = new Location(block.getWorld(), block.getLocation().getBlockX(), (block.getLocation().getBlockY() + 1), block.getLocation().getBlockZ());
        Block blockAbove = above.getBlock();

            if (blockAbove.getType() == Material.ACACIA_LOG || blockAbove.getType() == Material.BIRCH_LOG || blockAbove.getType() == Material.DARK_OAK_LOG || blockAbove.getType() == Material.JUNGLE_LOG || blockAbove.getType() == Material.OAK_LOG || blockAbove.getType() == Material.SPRUCE_LOG) {



                if (player.getActiveItem() != null) {

                    breakBlock(blockAbove, player);

                    System.out.println();

                    if (player.getItemInUse().getDurability() > player.getActiveItem().getType().getMaxDurability()) {
                        player.getInventory().remove(player.getActiveItem());
                        player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0f, 1.0f);
                        return;
                    }

                    player.getItemInUse().setDurability((short) (player.getItemInUse().getDurability() + 1));

                }

            }

    }
    
}
