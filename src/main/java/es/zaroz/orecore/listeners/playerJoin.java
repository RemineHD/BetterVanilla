package es.zaroz.orecore.listeners;

import es.zaroz.orecore.discord.DiscordService;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerJoin implements Listener {


    @EventHandler
    public void playerJoin(PlayerJoinEvent playerJoinEvent) {

        playerJoinEvent.setJoinMessage(null);

        Player player = playerJoinEvent.getPlayer();

        DiscordService discordService = DiscordService.getInstance();
        if (!discordService.isUserVerified(player.getUniqueId())) {

            String key = discordService.linkAccount(player.getUniqueId(), null);

            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCore SMP \n \n &fParece que es tu primera vez jugando en &6OreCore&f! \n &fTe damos la bienvenida, pero antes de acceder al servidor debes realizar unos sencillos pasos: \n \n &fAccede a &9Discord &f y busca por el BOT llamado: &3OreCore \n &fA continuación enviele el siguiente codigo por mensaje privado: \n &d" + key + " \n \n &fUna vez realizado esto, vuelva a conectarse al servidor. \n &6INFO: &7Si tiene algun problema contacte con cualquier miembro del equipo. \n \n &9Powered by Zaroz"));
            return;
        }

        if (!discordService.isIpVerified(player.getUniqueId(), player.getAddress().toString())) {



            discordService.verifyIp(player.getUniqueId(), player.getAddress().toString(), callback -> {
                switch (callback) {
                    case Denied:
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &d&lOreCore SMP \n \n &cHemos denegado tu conexión de forma inmediata, ya que tu IP forma parte de nuestra lista \n &c de IPs bloqueadas. Tu inicio de sesión a sido registrado y sera notificado al equipo Administrativo. \n \n &9Powered by Zaroz."));
                        return;
                    case Allowed:

                        return;
                    case UserNotFound:
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &cZaroz Games Database \n \n &cWe can't found your username in our database. Please, report this to the Development Team \n &cThanks in advance for your coperation. \n \n &9Powered by Zaroz."));
                        return;
                    case UserNotLinked:
                        String key = discordService.linkAccount(player.getUniqueId(), null);
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCore SMP \n \n &fParece que es tu primera vez jugando en &6OreCore&f! \n &fTe damos la bienvenida, pero antes de acceder al servidor debes realizar unos sencillos pasos: \n \n &fAccede a &9Discord &f y busca por el BOT llamado: &3OreCore \n &fA continuación enviele el siguiente codigo por mensaje privado: \n &d" + key + " \n \n &fUna vez realizado esto, vuelva a conectarse al servidor. \n &6INFO: &7Si tiene algun problema contacte con cualquier miembro del equipo. \n \n &9Powered by Zaroz"));
                        return;
                    case DmClosed:
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCore SMP \n \n &fHemos rechazado su conexión por que no pudo ser verificada. \n &f Información a cerca del problema: \n \n &eEl usuario tiene los mensajes privados desactivados o a bloqueado al BOT &7(&dOreCore&7)&e. \n \n &fSolución recomendada: \n \n &eActive los mensajes directos o desbloquee el bot de OreCore \n &9Powered by Zaroz."));
                        return;
                    case TimedOut: case UnknownError:
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &cZaroz Games Database \n \n &cWe can't connect to our database. Please, report this to the Development Team \n &cThanks in advance for your coperation. \n \n &9Powered by Zaroz. \n &7Data: 07# es.zaroz.core.orecore.bettervanilla.databaseHandler.productionPostgreSQL.connect(): timeOut."));
                        return;
                }
            });
            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', " &c&lSecurity System &8| &d&lOreCoreSMP \n \n &fUpps, tu IP no consta en nuestras bases de datos. \n &fPara poder acceder deberas verificar tu IP actual. \n &fRevisa tus mensajes privados de Discord para permitir la conexión. \n \n &cINFO: &7Si tienes lo DMs desactivados puedes no recibir el mensaje. \n \n &9Power by Zaroz."));
            return;

        }

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n" +
                " &d&lOreCore SMP &8| &fBetter Vanilla T1 \n" +
                " \n" +
                " &fBienvenid@ de nuevo &e" + player.getName() +
                "\n &fEsperemos que disfrutes tu estancia." +
                "\n\n "));

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.playSound(online.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 100, 1);
            online.sendActionBar(ChatColor.translateAlternateColorCodes('&', "&6⚜ &e" + player.getName() + " &fse a unido."));
        }

    }


    @EventHandler
    public void onQuit(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
        Player playerQuitted = playerQuitEvent.getPlayer();
        for (Player online : Bukkit.getOnlinePlayers()) { online.sendActionBar(ChatColor.translateAlternateColorCodes('&', "&6⚜ &e" + playerQuitted.getPlayer().getName() + " &fa salido."));}
    }

}
