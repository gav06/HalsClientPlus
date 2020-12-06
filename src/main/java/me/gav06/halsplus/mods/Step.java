package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import org.lwjgl.input.Keyboard;

public class Step extends Module {
    public Step() {
        super("Step", Keyboard.KEY_N);
    }

    public void onEnable() {
        mc.player.stepHeight = 1;
    }

    public void onDisable() {
        mc.player.stepHeight = 0.5f;
    }
}
