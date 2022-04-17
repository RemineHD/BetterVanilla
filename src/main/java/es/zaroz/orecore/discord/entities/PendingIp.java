package es.zaroz.orecore.discord.entities;

import es.zaroz.orecore.discord.enums.VerifyIpResult;

import javax.security.auth.callback.Callback;
import java.util.UUID;
import java.util.function.Consumer;

public class PendingIp {
    public UUID uuid;
    public String ip;
    public Consumer<VerifyIpResult> callback;
}
