package me.gav06.halsplus.mods;

import me.gav06.halsplus.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class FastXP extends Module {

    public FastXP() {
        super("FastXP", Keyboard.KEY_M);
    }


    @SubscribeEvent
    public void throwBottle(TickEvent.ClientTickEvent event) {
        if (mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE){


        }
    }
}
