package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import org.lwjgl.input.Keyboard;

public class GameInfo extends Module {

    public GameInfo() {
        super("GameInfo", Keyboard.KEY_M);
        // TODO Auto-generated constructor stub

    }
    public static boolean gameInfo = false;
    public void onEnable() {
        toggleGI();
    }

    public void onDisable() {
        toggleGI();
    }

    private void toggleGI() {
        gameInfo = !gameInfo;
    }
}
