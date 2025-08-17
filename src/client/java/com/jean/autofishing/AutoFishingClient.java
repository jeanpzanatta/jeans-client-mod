package com.jean.autofishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.Hand;
import net.minecraft.client.MinecraftClient;

public class AutoFishingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}

	private static int rodCastDelay = -1;

	/*
	Conta ticks de forma regressiva para dar um tempo até usar o item novamente.
	Esse código funciona mas está muito feio e com repetições, será necessário corrigir
	posteriormente.
	*/
	public void tick(MinecraftClient client){
		if(rodCastDelay > 0){
			rodCastDelay--;
		}
		if(rodCastDelay == 0){
			try {
				assert client.interactionManager != null;
				client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
				rodCastDelay = -1;
			} catch (NullPointerException e){
				AutoFishing.LOGGER.info("\uD83C\uDFA3❌ Não foi possível pegar o peixe automaticamente");
			}
		}
	}

	public static void setRodCastDelay(int delayTicks){
		rodCastDelay = delayTicks;
	}
}