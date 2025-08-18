package com.jeans.mods.features.fishing;

import com.jeans.mods.features.TickableFeature;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoFishing implements TickableFeature {
	private static int rodCastDelay = -1; //inicializa com -1 para não ter risco de usar o item de forma errada.

	public void tick(MinecraftClient client){
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