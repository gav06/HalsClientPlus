package me.gav06.halsplus;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Module {
    public String name;
    public boolean toggled;
    public int keyCode;
    public Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, int key) {
        this.name = name;
        this.keyCode = key;
    }

    public boolean isEnabled() {
        return toggled;
    }

    public int getKey() {
        return keyCode;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }


}
