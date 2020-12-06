package me.gav06.halsplus;

import net.minecraft.client.Minecraft;

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

    }

    public void onDisable() {

    }
}
