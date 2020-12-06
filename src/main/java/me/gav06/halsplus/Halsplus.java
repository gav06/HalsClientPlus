package me.gav06.halsplus;

import me.gav06.halsplus.mods.FakePlayer;
import me.gav06.halsplus.mods.Fullbright;
import me.gav06.halsplus.mods.Rage;
import me.gav06.halsplus.mods.Step;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Mod(
        modid = Halsplus.MOD_ID,
        name = Halsplus.MOD_NAME,
        version = Halsplus.VERSION
)
public class Halsplus {

    public static final String MOD_ID = "halsplus";
    public static final String MOD_NAME = "Halsplus";
    public static final String VERSION = "1.0-SNAPSHOT";


    @Mod.Instance(MOD_ID)
    public static Halsplus INSTANCE;


    public static ArrayList<Module> array_hacks = new ArrayList<>();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Display.setTitle("Hal's Client+");
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //calling hud renderer, and key input
        MinecraftForge.EVENT_BUS.register(new KeyEvent());
        MinecraftForge.EVENT_BUS.register(new DrawHUD());


        //registering modules
        array_hacks.add(new Fullbright());
        array_hacks.add(new Step());
        array_hacks.add(new FakePlayer());
        array_hacks.add(new Rage());


    }

    private static final Random RANDOM = new Random();

    public static int random(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
