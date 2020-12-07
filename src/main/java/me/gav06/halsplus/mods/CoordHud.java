package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import me.gav06.halsplus.RenderUtil;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class CoordHud extends Module {

    public CoordHud() {
        super("Coords", Keyboard.KEY_UP);
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @SubscribeEvent
    public void drawCoords(RenderGameOverlayEvent.Post event) {
        if (!(event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE))
            return;

        if (!mc.gameSettings.showDebugInfo) {
            ScaledResolution sr = new ScaledResolution(mc);
            int height = sr.getScaledHeight();
            double x = round(mc.player.posX,1);
            double y = round(mc.player.posY,1);
            double z = round(mc.player.posZ,1);

            if (mc.currentScreen instanceof GuiChat) {

                switch (mc.player.dimension) {
                    case 0:
                        RenderUtil.drawTextWithBackdrop("( X: " + round(x/8,1) + " Z: " + round(z/8,1) + " )",2,height - 34,-1);
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 24, -1);
                        break;
                    case -1:
                        RenderUtil.drawTextWithBackdrop("( X: " + round(x*8,1) + " Z: " + round(z*8,1) + " )",2,height - 34,-1);
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 24, -1);
                        break;
                    case 1:
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 24, -1);
                        break;
                }
            } else {

                switch (mc.player.dimension) {
                    case 0:
                        RenderUtil.drawTextWithBackdrop("( X: " + round(x/8,1) + " Z: " + round(z/8,1) + " )",2,height - 20,-1);
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 10, -1);
                        break;
                    case -1:
                        RenderUtil.drawTextWithBackdrop("( X: " + round(x*8,1) + " Z: " + round(z*8,1) + " )",2,height - 20,-1);
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 10, -1);
                        break;
                    case 1:
                        RenderUtil.drawTextWithBackdrop("X: " +  x + " Y: " + y + " Z: " + z, 2, height - 10, -1);
                        break;
                }
            }
        }
    }
}
