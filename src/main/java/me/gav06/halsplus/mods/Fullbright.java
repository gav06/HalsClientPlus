package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", Keyboard.KEY_B);
    }

    public void onEnable() {
        mc.gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }

}
