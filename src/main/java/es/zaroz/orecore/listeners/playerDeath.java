package es.zaroz.orecore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDeath implements Listener {

    @EventHandler
    public void Muerte(PlayerDeathEvent e) {

        if (e.getDeathMessage().contains("Wither")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &0Whiter"));
            }
        } else if (e.getDeathMessage().contains("dragon")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por &dLa Dragona"));
            }
        } else if (e.getDeathMessage().contains("was stung to death")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por una &dabeja"));
            }
        } else if (e.getDeathMessage().contains("Cave Spider")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por una &cAraña de Cueva"));
            }
        } else if (e.getDeathMessage().contains("Creeper")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &aCreeper"));
            }
        } else if (e.getDeathMessage().contains("Drowned")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &bAhogado"));
            }
        } else if (e.getDeathMessage().contains("Guardian")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &3Guardian"));
            }
        } else if (e.getDeathMessage().contains("Enderman")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &5Enderman"));
            }
        } else if (e.getDeathMessage().contains("Endermite")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dEndermite"));
            }
        } else if (e.getDeathMessage().contains("Blaze")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &6Blaze"));
            }
        } else if (e.getDeathMessage().contains("Ghast")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &cGhast"));
            }
        } else if (e.getDeathMessage().contains("Husk")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &eZombie Momificado"));
            }
        } else if (e.getDeathMessage().contains("Llama")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por una Llama"));
            }
        } else if (e.getDeathMessage().contains("Magma")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &cMagma cube"));
            }
        } else if (e.getDeathMessage().contains("Phantom")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dPhantom"));
            }
        } else if (e.getDeathMessage().contains("Ravager")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &4Ravager"));
            }
        } else if (e.getDeathMessage().contains("Shulker")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dShulker"));
            }
        } else if (e.getDeathMessage().contains("Silverfish")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &7Silverfish"));
            }
        } else if (e.getDeathMessage().contains("Skeleton")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por &7Esqueleto"));
            }
        } else if (e.getDeathMessage().contains("Slime")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &aSlime"));
            }
        } else if (e.getDeathMessage().contains("Spider")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por una &8Araña"));
            }
        } else if (e.getDeathMessage().contains("Stray")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &8Stray"));
            }
        } else if (e.getDeathMessage().contains("Vex")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dVex"));
            }
        } else if (e.getDeathMessage().contains("Vindicator")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dVindicador"));
            }
        } else if (e.getDeathMessage().contains("Witch")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por una &dBruja"));
            }
        } else if (e.getDeathMessage().contains("Whiter Skeleton")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &0Esqueleto Whiter"));
            }
        } else if (e.getDeathMessage().contains("Wolf")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &8Lobo"));
            }
        } else if (e.getDeathMessage().contains("Zombie")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &aZombie"));
            }
        } else if (e.getDeathMessage().contains("Zombie Pigman")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dZombie Pigman"));
            }
        } else if (e.getDeathMessage().contains("Zombie Villager")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue eliminado por un &dAldeano Zombie"));
            }
        } else if (e.getDeathMessage().contains("hit the ground too hard")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fa muerto por caida "));
            }
        } else if (e.getDeathMessage().contains("drowned")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse ahogo "));
            }
        } else if (e.getDeathMessage().contains("swim in lava")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fintento nadar en lava "));
            }
        } else if (e.getDeathMessage().contains("burned to death")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse quemo hasta morir "));
            }
        } else if (e.getDeathMessage().contains("discovered the floor was lava")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fha muerto en lava "));
            }
        } else if (e.getDeathMessage().contains("struck by lightning")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue golpeado por un rayo "));
            }
        } else if (e.getDeathMessage().contains("blew up")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fexploto "));
            }
        } else if (e.getDeathMessage().contains("went up in flames")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fsalio ardiendo "));
            }
        } else if (e.getDeathMessage().contains("shot")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue alcanzado por una flecha "));
            }
        } else if (e.getDeathMessage().contains("pricked to death")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse murio "));
            }
        } else if (e.getDeathMessage().contains("falling anvil")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &ffue fuertemente golpeado por un yunque "));
            }
        } else if (e.getDeathMessage().contains("starved")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fYou know the way. "));
            }
        } else if (e.getDeathMessage().contains("suffocated in")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse murio asfixiado "));
            }
        } else if (e.getDeathMessage().contains("fell out of the world")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse resbalo en el end y callo del mundo. "));
            }
        } else if (e.getDeathMessage().contains("tried to swim in lava")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fse quemo el dedo gordo."));
            }
        } else if (e.getDeathMessage().contains("fell from a high place")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                e.setDeathMessage(null);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[☠] &e" + e.getEntity().getPlayer().getDisplayName() + " &fcalló desde muy alto. "));
            }
        }
        for (Player online : Bukkit.getOnlinePlayers()) { online.playSound(online.getLocation(), Sound.ENTITY_WITHER_SKELETON_DEATH, 5.0F, 2.0F); }
    }

}
