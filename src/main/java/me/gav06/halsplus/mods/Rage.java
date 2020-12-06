package me.gav06.halsplus.mods;

import me.gav06.halsplus.Halsplus;
import me.gav06.halsplus.Module;
import me.gav06.halsplus.TimerUtils;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Rage extends Module {

    public TimerUtils timer;

    public Rage() {
        super("Rage", Keyboard.KEY_Y);
        // TODO Auto-generated constructor stub
        this.timer = new TimerUtils();
    }



    @SubscribeEvent
    public void doRage(TickEvent.ClientTickEvent event) {
        if(timer.isDelay(10)) {
            mc.getConnection().sendPacket(new CPacketPlayer.Rotation(Halsplus.random(-160, 160), Halsplus.random(-160, 160), true));
            timer.setLastMS();
        }
    }
}

