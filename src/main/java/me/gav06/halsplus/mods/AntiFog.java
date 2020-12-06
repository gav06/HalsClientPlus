package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AntiFog extends Module {
    public AntiFog() {
        super("AntiFog", Keyboard.KEY_J);
    }

    @SubscribeEvent
    public void fogBeGone(EntityViewRenderEvent.FogDensity event) {
        event.setDensity(0);
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void onFogColor(EntityViewRenderEvent.FogColors event) {
        event.setRed(55);
        event.setGreen(55);
        event.setBlue(55);
    }


}
