package me.gav06.halsplus;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gav06.halsplus.mods.GameInfo;
import me.gav06.halsplus.mods.GuiOpen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class DrawHUD {
    Minecraft mc = Minecraft.getMinecraft();

    public static class modComparator implements Comparator<Module> {

        @Override
        public int compare(Module arg0, Module arg1) {
            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.name) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.name)) {
                return -1;
            }

            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.name) < Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.name)) {
                return 1;
            }
            return 0;
        }
    }


    @SubscribeEvent
    public void renderHud(RenderGameOverlayEvent.Post event) {
        if (!(event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE))
            return;

        if (!mc.gameSettings.showDebugInfo) {
            mc.fontRenderer.drawStringWithShadow("Gav's Client v1",2,2,-1);

            ScaledResolution sr = new ScaledResolution(mc);
            int width = sr.getScaledWidth();
            int height = sr.getScaledHeight();

            Collections.sort(Halsplus.array_hacks, new modComparator());
            int count = 0;
            int bcount = 0;

            for (Module m : Halsplus.array_hacks) {

                String keyName = Keyboard.getKeyName(m.keyCode);
                String bindInfo = m.name + "=" + keyName;


                if (GuiOpen.isGuiOpen) {
                    mc.fontRenderer.drawStringWithShadow("Press RSHIFT to toggle bind list", width - mc.fontRenderer.getStringWidth("Press RSHIFT to toggle bind list") - 2, 2, -1);
                    if (m.toggled) {
                        mc.fontRenderer.drawStringWithShadow(bindInfo, width - mc.fontRenderer.getStringWidth(bindInfo) - 2, (bcount * 10) + 12, -1);
                    } else {
                        mc.fontRenderer.drawStringWithShadow(ChatFormatting.GRAY + bindInfo, width - mc.fontRenderer.getStringWidth(bindInfo) - 2, (bcount * 10) + 12, -1);
                    }
                    bcount++;
                } else {
                    mc.fontRenderer.drawStringWithShadow("Press RSHIFT to toggle bind list", width - mc.fontRenderer.getStringWidth("Press RSHIFT to toggle bind list") - 2, 2, -1);
                }
                if (!m.toggled)
                    continue;
                mc.fontRenderer.drawStringWithShadow(">"+m.name, 2, 12 + (count * 10), getRGBWave(4,1,.7f,count * 250));
                count++;


            }
            if (GameInfo.gameInfo) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                Date date = new Date(System.currentTimeMillis());

                int ping;
                if (mc.getCurrentServerData() == null) {
                    ping = 0;
                } else {
                    ping = (int) mc.getCurrentServerData().pingToServer;
                }

                String fps = "FPS: " + Minecraft.getDebugFPS();
                String server = "Brand: " + mc.player.getServerBrand();
                String time = "Time: " + formatter.format(date);
                //String StringPing = "Ping: " + ping;
                mc.fontRenderer.drawStringWithShadow(server, width - mc.fontRenderer.getStringWidth(server) - 2, height - 10, -10);
                mc.fontRenderer.drawStringWithShadow(fps, width - mc.fontRenderer.getStringWidth(fps) - 2, height - 30, -10);

                mc.fontRenderer.drawStringWithShadow(time, width - mc.fontRenderer.getStringWidth(time) - 2, height - 20, -10);
            }
        }
    }

    public static int getRGBWave(float seconds, float brightness, float saturation, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (float) (seconds * 1000);
        int color = Color.HSBtoRGB(hue, saturation, brightness);
        return color;
    }
}
