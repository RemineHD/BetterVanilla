package es.zaroz.orecore.discord.entities;

import es.zaroz.orecore.discord.enums.LinkResult;

import java.util.UUID;
import java.util.function.Consumer;

public class PendingLink {
    public UUID uuid;
    public Consumer<LinkResult> callback;
}
