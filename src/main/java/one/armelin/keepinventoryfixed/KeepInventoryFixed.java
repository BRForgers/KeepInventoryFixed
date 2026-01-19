package one.armelin.keepinventoryfixed;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import one.armelin.keepinventoryfixed.systems.KeepInventorySystem;


public class KeepInventoryFixed extends JavaPlugin {

    public static final String NAME = "KeepInventoryFixed";
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private static KeepInventoryFixed instance;

    public KeepInventoryFixed(JavaPluginInit init) {
        super(init);
        instance = this;

        LOGGER.atInfo().log("Keep Inventory Fixed initializing...");
    }


    @Override
    protected void setup() {
        super.setup();

        this.getEntityStoreRegistry().registerSystem(new KeepInventorySystem());
    }

    @Override
    protected void start() {
        super.start();
    }

    @Override
    protected void shutdown() {
        super.shutdown();
    }

    public static KeepInventoryFixed getInstance() {
        return instance;
    }
}
