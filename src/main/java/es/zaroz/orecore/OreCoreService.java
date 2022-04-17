package es.zaroz.orecore;


import java.util.logging.Level;

public abstract class OreCoreService {
    public abstract void onStart();
    public abstract void onStop();

    protected void info(Object message) {
        OreCore.getInstance().getLogger().log(Level.INFO, message.toString());
    }

    protected void warn(Object message) {
        OreCore.getInstance().getLogger().log(Level.WARNING, message.toString());
    }

    protected void error(Object message) {
        OreCore.getInstance().getLogger().log(Level.SEVERE, message.toString());
    }
}
