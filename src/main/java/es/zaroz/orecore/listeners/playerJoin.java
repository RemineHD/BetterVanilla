package es.zaroz.orecore.listeners;

import es.zaroz.orecore.discord.DiscordService;
import es.zaroz.orecore.discord.enums.LinkResult;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.function.Consumer;

public class playerJoin implements Listener {


    @EventHandler
    public void playerJoin(PlayerJoinEvent playerJoinEvent) {

        Player player = playerJoinEvent.getPlayer();

        DiscordService discordService = DiscordService.getInstance();
        if (!discordService.isUserVerified(player.getUniqueId())) {

            String key = discordService.linkAccount(player.getUniqueId());

            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCore SMP \n \n &fParece que es tu primera vez jugando en &6OreCore&f! \n &fTe damos la bienvenida, pero antes de acceder al servidor debes realizar unos sencillos pasos: \n \n &fAccede a &9Discord &f y busca por el BOT llamado: &3OreCore \n &fA continuación enviele el siguiente codigo por mensaje privado: \n &d" + key + " \n \n &fUna vez realizado esto, vuelva a conectarse al servidor. \n &6INFO: &7Si tiene algun problema contacte con cualquier miembro del equipo. \n \n &9Powered by Zaroz"));
            return;
        }

        if (!discordService.isIpVerified(player.getUniqueId(), player.getAddress().toString())) {



            discordService.verifyIp(player.getUniqueId(), player.getAddress().toString(), callback -> {
                switch (callback) {
                    case Denied:
                        player.kickPlayer("Denied.");
                        return;
                    case Allowed:

                        return;
                    case UserNotFound:
                        player.kickPlayer("User not found.");
                        return;
                    case UserNotLinked:
                        player.kickPlayer("Account not linked.");
                        return;
                    case DmClosed:
                        player.kickPlayer("DM Closed.");
                        return;
                    case TimedOut: case UnknownError:
                        player.kickPlayer("TimeOut.");
                        return;
                }
            });

            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCoreSMP \n \n &fUpps, tu IP no consta en nuestras bases de datos. \n &fPara poder acceder deberas verificar tu IP actual. \n &fRevisa tus mensajes privados de Discord para permitir la conexión. \n \n &cINFO: &7Si tienes lo DMs desactivados puedes no recibir el mensaje. \n \n &9Power by Zaroz."));

            return;

        }

        player.sendMessage("Welcome!");


    }

}
