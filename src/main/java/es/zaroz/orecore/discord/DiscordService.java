package es.zaroz.orecore.discord;

import com.google.gson.Gson;
import es.zaroz.orecore.OreCoreService;
import es.zaroz.orecore.OreCore;
import es.zaroz.orecore.discord.entities.PendingLink;
import es.zaroz.orecore.discord.enums.LinkResult;
import es.zaroz.orecore.discord.enums.VerifyIpResult;
import es.zaroz.orecore.discord.listeners.MessageListener;
import es.zaroz.orecore.discord.models.DiscordServiceConfiguration;
import es.zaroz.orecore.discord.models.DiscordServiceData;
import es.zaroz.orecore.utils.Discord.EventWaiter;
import es.zaroz.orecore.utils.IO.FileReader;
import es.zaroz.orecore.utils.IO.PathCombine;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;

public class DiscordService extends OreCoreService {

    private static DiscordService instance;

    private final OreCore oreCore;

    private JDA client;
    private MessageListener messageListener;
    private final EventWaiter eventWaiter = new EventWaiter();
    private DiscordServiceData data;
    public DiscordService(OreCore plugin){
        instance = this;
        oreCore = plugin;
    }

    private void loadData(){
        File dataFile = new File(PathCombine.Combine(OreCore.getInstance().getDataFolder().getAbsolutePath(), "discord.dat"));
        if(!dataFile.exists()){
            warn("Discord data file not found");
            data = new DiscordServiceData();
            data.linkedAccounts = new HashMap<>();
            data.allowedIps = new HashMap<>();
            saveData();
            return;
        }

        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(FileReader.readAllBytes(PathCombine.Combine(OreCore.getInstance().getDataFolder().getAbsolutePath(), "discord.dat")));
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            data = (DiscordServiceData) objectInputStream.readObject();
        }catch (Exception e){
            error("Error while loading discord data\n" + e);
        }
    }

    private void saveData(){
        try {
            FileReader.writeAllBytes(PathCombine.Combine(OreCore.getInstance().getDataFolder().getAbsolutePath(), "discord.dat"), data.toBytes());
        }catch (Exception e){
            error("Error while saving discord data\n" + e.toString());
        }
    }

    public static DiscordService getInstance(){
        return instance;
    }

    @Override
    public void onStart() {
        info("Discord service starting");
        //check if file exists
        File configFile = new File(PathCombine.Combine(OreCore.getInstance().getDataFolder().getAbsolutePath(), "discord.json"));
        if(!configFile.exists()){
            warn("Discord config file not found");
            try{
                configFile.createNewFile();
                FileReader.writeAllText(PathCombine.Combine(OreCore.getInstance().getDataFolder().getAbsolutePath(), "discord.json"), new Gson().toJson(new DiscordServiceConfiguration()));
            }catch (Exception e){
                error("Error while creating discord config file\n" + e);
            }
        }

        DiscordServiceConfiguration config = new Gson()
                .fromJson(FileReader.readAllText(
                                PathCombine.Combine(oreCore.getDataFolder().getAbsolutePath(), "discord.json")),
                        DiscordServiceConfiguration.class);


        try {
            client = JDABuilder.createDefault(config.token).build();
        }catch (Exception e){
            error("Error while creating discord client\n" + e);
        }

        loadData();
        messageListener = new MessageListener(this, data);
        client.addEventListener(messageListener);
        client.addEventListener(eventWaiter);
        try{
            client.awaitReady();
        }catch (Exception e){
            error("Error while waiting for discord client to be ready\n" + e);
        }
        info("Discord service started");
    }

    @Override
    public void onStop() {
        saveData();
        client.shutdown();
        info("Discord service stopped");
    }

    public boolean isUserVerified(UUID uuid){
        return data.linkedAccounts.containsKey(uuid);
    }

    public boolean isIpVerified(UUID uuid, String ip){
        if (ip.contains(":")){
            ip = ip.substring(0, ip.indexOf(":"));
        }

        return data.allowedIps.containsKey(uuid) && data.allowedIps.get(uuid).contains(ip);
    }

    private String random4Digit(){
        return String.valueOf(new Random().nextInt(9000) + 1000);
    }

    public String linkAccount(UUID uuid, Consumer<LinkResult> callback){
        String key = random4Digit();
        while (messageListener.pendingLinks.containsKey(key)) {
            key = random4Digit();
        }
        PendingLink pendingLink = new PendingLink();
        pendingLink.callback = callback;
        pendingLink.uuid = uuid;
        messageListener.pendingLinks.put(key,pendingLink);

        return key;
    }

    public void manualSave(){
        saveData();
        info("Manual save completed");
    }

    public void verifyIp(UUID uuid, String ip, Consumer<VerifyIpResult> callback){
        if (!isUserVerified(uuid)){
            callback.accept(VerifyIpResult.UserNotLinked);
            return;
        }

        if (ip.contains(":")){
            ip = ip.substring(0, ip.indexOf(":"));
        }
        User user = client.getUserById(data.linkedAccounts.get(uuid));

        if (user == null){
            warn("User not found with id " + data.linkedAccounts.get(uuid));
            callback.accept(VerifyIpResult.UserNotFound);
            return;
        }

        String finalIp = ip;
        user.openPrivateChannel().queue(privateChannel -> {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Verificar IP");
            embedBuilder.setDescription("Se ha detectado una ip no verificada. Quieres permitir la conexión desde esta ip?");
            embedBuilder.setTimestamp(Instant.now());
            embedBuilder.setColor(Color.red);
            embedBuilder.addField("Ip", finalIp, false);

            MessageBuilder messageBuilder = new MessageBuilder();
            messageBuilder.setEmbeds(embedBuilder.build());

            ArrayList<net.dv8tion.jda.api.interactions.components.buttons.Button> buttons = new ArrayList<net.dv8tion.jda.api.interactions.components.buttons.Button>();
            buttons.add(Button.danger("no", "No"));
            buttons.add(Button.success("yes", "Si"));

            messageBuilder.setActionRows(ActionRow.of(buttons));

            privateChannel.sendMessage(messageBuilder.build()).queue(message -> {
                eventWaiter.waitForEvent(ButtonInteractionEvent.class, filter -> {
                    return filter.getMessage().getId().equals(message.getId());
                }, event -> {
                    if (event.getButton().getId().equals("yes")){
                        if (!data.allowedIps.containsKey(uuid)){
                            data.allowedIps.put(uuid, new ArrayList<>());
                        }

                        if (!data.allowedIps.get(uuid).contains(finalIp)){
                            data.allowedIps.get(uuid).add(finalIp);
                        }

                        callback.accept(VerifyIpResult.Allowed);
                    }else {
                        callback.accept(VerifyIpResult.Denied);
                    }
                });
            });
        });
    }
}
