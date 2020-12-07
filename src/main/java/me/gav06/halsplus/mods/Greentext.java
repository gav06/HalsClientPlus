package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Greentext extends Module {
    public Greentext() {
        super("AutoGreentext", Keyboard.KEY_H);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if (!event.getMessage().startsWith("/") || !event.getMessage().startsWith(">")) {
            event.setMessage(">"+event.getOriginalMessage());
        }
    }

}
