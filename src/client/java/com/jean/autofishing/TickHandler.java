package com.jean.autofishing;

import net.minecraft.client.MinecraftClient;

public class TickHandler {
    private static int rodCastDelay = -1; //inicializa com -1 para não ter risco de usar o item de forma errada.

    public static void tick(MinecraftClient client){
        if(rodCastDelay > 0){
            rodCastDelay--;
        }
        if(rodCastDelay == 0){
            RodInteractor.castRod(client);
            rodCastDelay--;
        }
    }

    public static void scheduleRodCast(int delayTicks) {
        rodCastDelay = delayTicks;
    }
}
