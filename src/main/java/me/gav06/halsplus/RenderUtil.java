package me.gav06.halsplus;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class RenderUtil {

    public static void drawTextWithBackdrop(String text, int x, int y, int color) {
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int w = sr.getScaledWidth();
        int h = sr.getScaledHeight();
        Gui.drawRect(x -1,y - 1,x +  fr.getStringWidth(text) + 1, y + fr.FONT_HEIGHT, 0x80000000 );
        fr.drawStringWithShadow(text, x, y, color);
    }
}
