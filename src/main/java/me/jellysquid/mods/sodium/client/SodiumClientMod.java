package me.jellysquid.mods.sodium.client;

import me.jellysquid.mods.sodium.Reference;
import me.jellysquid.mods.sodium.client.gui.SodiumGameOptions;
import me.jellysquid.mods.sodium.client.util.UnsafeUtil;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, clientSideOnly = true)
public class SodiumClientMod {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final SodiumGameOptions CONFIG = loadConfig();

    public static SodiumGameOptions options() {
        return CONFIG;
    }

    public static Logger logger() {
        return LOGGER;
    }

    private static SodiumGameOptions loadConfig() {
        SodiumGameOptions config = SodiumGameOptions.load(new File("config/sodium-options.json"));
        onConfigChanged(config);

        return config;
    }

    public static void onConfigChanged(SodiumGameOptions options) {
        UnsafeUtil.setEnabled(options.advanced.useMemoryIntrinsics);
    }
}
