package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import org.lwjgl.input.Keyboard;

public class ExampleMod extends Module {

    public ExampleMod() {
        super("ExampleMod", Keyboard.KEY_RIGHT);
    }
}
