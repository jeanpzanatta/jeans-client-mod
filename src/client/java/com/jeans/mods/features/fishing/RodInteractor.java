package com.jeans.mods.features.fishing;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class RodInteractor {
    //Classe focada e utilizar a vara na main hand do personagem assim que um item for pescado.

    // Não sei mais por que fiz duas classes para isso, vou juntar tudo depois, por enquanto funciona.
    private static boolean isAutoFishingEnable = true;

    public static void castRod(MinecraftClient client) {
        // Achhei melhor testar a condição do player ser nula no "if" em fez de ficar jogando um monte de Try Catch.
        if (client != null && client.player != null && client.interactionManager != null && isAutoFishingEnable) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
        }
    }

    public static void castScheduler(int delayTicks){
        AutoFishing.scheduleRodCast(delayTicks);
    }

    public static void toggleAutoFishing(){
        isAutoFishingEnable = !isAutoFishingEnable;
    }


}
