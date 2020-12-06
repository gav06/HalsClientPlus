package me.gav06.halsplus;

import me.gav06.halsplus.mods.GuiOpen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyEvent {
    public static int key;
    @SubscribeEvent
    public void KeyPress(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            key = Keyboard.getEventKey();

            if (key == Keyboard.KEY_RSHIFT) {
                GuiOpen.toggle();
            }

            for (Module m : Halsplus.array_hacks) {
                if (m.getKey() == key) {
                    m.toggle();
                }
            }
        }
    }

}
