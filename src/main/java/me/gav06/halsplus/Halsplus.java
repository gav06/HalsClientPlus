package me.gav06.halsplus;

import me.gav06.halsplus.mods.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.Random;

@Mod(
        modid = Halsplus.MOD_ID,
        name = Halsplus.MOD_NAME,
        version = Halsplus.VERSION
)
public class Halsplus {

    public static final String MOD_ID = "gavhack";
    public static final String MOD_NAME = "Gavhack";
    public static final String VERSION = "1.0-SNAPSHOT";


    @Mod.Instance(MOD_ID)
    public static Halsplus INSTANCE;


    public static ArrayList<Module> array_hacks = new ArrayList<>();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Display.setTitle("Gav's Client");

    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //calling hud renderer, and key input
        MinecraftForge.EVENT_BUS.register(new KeyEvent());
        MinecraftForge.EVENT_BUS.register(new DrawHUD());

        Minecraft.getMinecraft().gameSettings.gammaSetting = 1;

        //registering modules
        array_hacks.add(new Fullbright());
        array_hacks.add(new Step());
        array_hacks.add(new FakePlayer());
        array_hacks.add(new NoFall());
        array_hacks.add(new GameInfo());
        array_hacks.add(new ChatSuffix());
        array_hacks.add(new CoordHud());
        array_hacks.add(new AntiFog());



    }



    private static final Random RANDOM = new Random();

    public static int random(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
