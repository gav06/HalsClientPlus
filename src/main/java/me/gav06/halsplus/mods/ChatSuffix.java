package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.StringEscapeUtils;
import org.lwjgl.input.Keyboard;

public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", Keyboard.KEY_O);
    }

    String suffix = StringEscapeUtils.unescapeCsv(" \uff5c \uff27\uff41\uff56\uff07\uff53 \uff23\uff4c\uff49\uff45\uff4e\uff54");

    @SubscribeEvent
    public void addSuffix(ClientChatEvent event) {
        if (!event.getMessage().startsWith("/")) {
            event.setMessage(event.getMessage().concat(suffix));
        }
    }

}
