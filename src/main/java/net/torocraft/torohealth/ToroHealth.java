package net.torocraft.torohealth;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.torocraft.torohealth.config.Config;
import net.torocraft.torohealth.config.loader.ConfigLoader;
import net.torocraft.torohealth.display.Hud;
import net.torocraft.torohealth.util.RayTrace;

import java.util.Random;

@Mod(ToroHealth.MODID)
public class ToroHealth {

    public static final String MODID = "torohealth";

    public static Config CONFIG = new Config();
    public static final Hud HUD = new Hud();
    public static RayTrace RAYTRACE = new RayTrace();
    public static boolean IS_HOLDING_WEAPON = false;
    public static final Random RAND = new Random();

    private static final ConfigLoader<Config> CONFIG_LOADER = new ConfigLoader<>(new Config(), ToroHealth.MODID + ".json", config -> ToroHealth.CONFIG = config);

    public ToroHealth() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        ToroHealthClient.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
        CONFIG_LOADER.load();
    }

}
