package es.zaroz.orecore.discord.models;

import com.google.common.primitives.UnsignedLong;
import es.zaroz.orecore.OreCore;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.logging.Level;

public class DiscordServiceData implements Serializable {
    public HashMap<UUID, String> linkedAccounts;
    public HashMap<UUID, ArrayList<String>> allowedIps;
    public byte[] toBytes() {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.flush();
            bytes = baos.toByteArray();
            oos.close();
        } catch (IOException e) {
            OreCore.getInstance().getLogger().log(Level.SEVERE, "Error while serializing DiscordServiceData" + e.toString());
        }

        return bytes;
    }
}
