package com.jeans.mods.features.flying;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Flying {
    private static boolean isFlyingEnable = true;
    private static int counter = 0;

    public static void tick(MinecraftClient client){
        if (!isFlyingEnable || client.player == null) return;
        var p = client.player;
        p.getAbilities().allowFlying = true;
        spoofTinyFall(client);
    }

    /* Não estava conseguindo descobrir uma maneira de fazer o boneco voar sem o barco,
    ** então pedi para o chat GPT gerar algo que voasse como no criativo sem barco e que
    **  levasse uma queda a cada 40 ticks para evitar kick nos servidores Paper, e o código
    ** sugerido a seguir funcionou, então resolvi usar até pensar em algo melhor.*/

    private static void spoofTinyFall(MinecraftClient client) {
        var p = client.player;
        if (p == null || !p.getAbilities().flying) return; // só quando realmente voando

        if (++counter >= 40) {
            counter = 0;
            double x = p.getX(), y = p.getY(), z = p.getZ();
            p.setPosition(x, y - 0.4, z);
            p.fallDistance = 0.0F; // evita dano de queda cliente-side
        }
    }

    public static void toggle(){
        isFlyingEnable = !isFlyingEnable;
    }

    public static Text getButtonText(){
        return Text.literal(isFlyingEnable ? "Flying: ON": "Flying: OFF");
    }
}
