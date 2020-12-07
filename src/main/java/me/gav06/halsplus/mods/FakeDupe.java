package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import org.lwjgl.input.Keyboard;

public class FakeDupe extends Module {

    public FakeDupe() {
        super("FakeDupe", Keyboard.KEY_G);
    }

    public void onEnable() {
        int num = (int) (Math.random() * 30) + 1;
        mc.player.sendChatMessage(">I just duped " + num + " shulker boxes thanks to gav's client!");
        toggle();
    }
}
