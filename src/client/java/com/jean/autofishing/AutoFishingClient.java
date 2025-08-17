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

	private static int jogaVara = -1;

	/*
	Conta ticks de forma regressiva para dar um tempo até usar o item novamente.
	Esse código funciona mas está muito feio e com repetições, será necessário corrigir
	posteriormente.
	*/
	public void tick(MinecraftClient cliente){
		if(jogaVara > 0){
			jogaVara--;
		}
		if(jogaVara == 0){
			try {
				assert cliente.interactionManager != null;
				cliente.interactionManager.interactItem(cliente.player, Hand.MAIN_HAND);
				jogaVara = -1;
			} catch (NullPointerException e){
				AutoFishing.LOGGER.info("\uD83C\uDFA3❌ Não foi possível pegar o peixe automaticamente");
			}
		}
	}

	public static void setJogaVara(int contagem){
		jogaVara = contagem;
	}
}