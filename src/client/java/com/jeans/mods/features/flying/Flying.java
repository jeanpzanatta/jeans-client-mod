package com.jeans.mods.features.flying;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import static com.mojang.text2speech.Narrator.LOGGER;

public class Flying {
    private static boolean isFlyingEnable = true;
    private static int counter = 0;

    public static void tick(MinecraftClient client){
        if (client.player == null) return;
        var player = client.player;
        if (isFlyingEnable) {
            player.getAbilities().allowFlying = true;
            spoofTinyFall(client);
        }
        else {
            player.getAbilities().flying = false;
            player.getAbilities().allowFlying = false;
        }
    }

    private static void spoofTinyFall(MinecraftClient client) {
        var player = client.player;
        if (player == null || !player.getAbilities().flying) return; // só quando realmente voando
        // Nos meus testes o servidor aceita até 80 Ticks, usando 40 pra garantir.
        int FLYING_TICKS = 40;
        if (++counter >= FLYING_TICKS) {
            LOGGER.info("Está chamando a queda");
            counter = 0;
            final Vec3d velocity = player.getVelocity();
            // Velocidade minima para o server resetar o contador.
            double FALL_SPEED = -0.04;
            player.setVelocity(new Vec3d(velocity.x, FALL_SPEED - velocity.y, velocity.z));
        }
    }

    public static void toggle(){
        isFlyingEnable = !isFlyingEnable;
        LOGGER.info("isFlyingEnable = {}", isFlyingEnable);
    }

    public static Text getButtonText(){
        return Text.literal(isFlyingEnable ? "Flying: ON": "Flying: OFF");
    }
}
