package me.gav06.halsplus.mods;

import com.mojang.authlib.GameProfile;
import me.gav06.halsplus.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import org.lwjgl.input.Keyboard;
import java.util.UUID;

public class FakePlayer extends Module {

    public FakePlayer() {
        super("FakePlayer", Keyboard.KEY_L);
    }

    private EntityOtherPlayerMP fake_player;


    public void onEnable() {
        fake_player = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("a07208c2-01e5-4eac-a3cf-a5f5ef2a4700"), "Gavin"));
        fake_player.copyLocationAndAnglesFrom(mc.player);
        fake_player.rotationYawHead = mc.player.rotationYawHead;
        mc.world.addEntityToWorld(-100, fake_player);
    }

    public void onDisable() {
        try {
            mc.world.removeEntity(fake_player);
        } catch (Exception ignored) {}
    }
}
