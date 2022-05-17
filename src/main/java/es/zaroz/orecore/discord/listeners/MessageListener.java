package es.zaroz.orecore.discord.listeners;

import es.zaroz.orecore.discord.DiscordService;
import es.zaroz.orecore.discord.entities.PendingLink;
import es.zaroz.orecore.discord.enums.LinkResult;
import es.zaroz.orecore.discord.models.DiscordServiceData;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MessageListener extends ListenerAdapter {
    private DiscordService service;
    private DiscordServiceData data;
    public HashMap<String, PendingLink> pendingLinks = new HashMap<>();

    public MessageListener(DiscordService service, DiscordServiceData data){
        this.service = service;
        this.data = data;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        if (event.getChannelType().isGuild()) return;

        String content = event.getMessage().getContentRaw();

        if (pendingLinks.containsKey(content)){
            PendingLink link = pendingLinks.get(content);
            pendingLinks.remove(content);
            event.getMessage().addReaction("✔").queue();
            data.linkedAccounts.put(link.uuid, event.getAuthor().getId());
            //link.callback.accept(LinkResult.Success);
        }else {
            event.getMessage().addReaction("❌").queue();
        }
    }
}
