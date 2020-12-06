package me.gav06.halsplus;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gav06.halsplus.mods.GuiOpen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

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
            mc.fontRenderer.drawStringWithShadow("Hal's Client+ v1",2,2,-1);

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
                    if (m.toggled) {
                        mc.fontRenderer.drawStringWithShadow(bindInfo, width - mc.fontRenderer.getStringWidth(bindInfo) - 2, (bcount * 10) + 2, -1);
                    } else {
                        mc.fontRenderer.drawStringWithShadow(ChatFormatting.GRAY + bindInfo, width - mc.fontRenderer.getStringWidth(bindInfo) - 2, (bcount * 10) + 2, -1);
                    }
                    bcount++;
                } else {
                    mc.fontRenderer.drawStringWithShadow("Press RSHIFT to show binds", width - mc.fontRenderer.getStringWidth("Press RSHIFT to show binds") - 2, 2, -1);
                }


                if (!m.toggled)
                    continue;

                mc.fontRenderer.drawStringWithShadow(">" + m.name, 2, 12 + (count * 10), getRGBWave(4,1,.7f,count * 250));
                count++;
            }
        }
    }

    public static int getRGBWave(float seconds, float brightness, float saturation, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (float) (seconds * 1000);
        int color = Color.HSBtoRGB(hue, saturation, brightness);
        return color;
    }
}
