package com.jean.autofishing;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class RodInteractor {
    //Classe focada e utilizar a vara na main hand do personagem assim que um item for pescado.

    public static void castRod(MinecraftClient client) {
        // Achhei melhor testar a condição do player ser nula no "if" em fez de ficar jogando um monte de Try Catch.
        if (client != null && client.player != null && client.interactionManager != null) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            AutoFishing.LOGGER.info("🎣 Usou a vara de pesca");
        } else {
            AutoFishing.LOGGER.warn("🎣❌ Não foi possível usar a vara.");
        }
    }

    public static void castScheduler(int delayTicks){
        TickHandler.scheduleRodCast(delayTicks);
    }


}
