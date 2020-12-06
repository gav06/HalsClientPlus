package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", Keyboard.KEY_P);
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }


    @SubscribeEvent
    public void doNoFall(TickEvent.ClientTickEvent event) {
        if (mc.player.fallDistance > 2) {
            mc.player.connection.sendPacket(new CPacketPlayer(true));

        }

    }

}
