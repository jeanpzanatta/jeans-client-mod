package com.jeans.fishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AutoFishingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(TickHandler::tick);
		// Chama minha classe para verificar o estado da pesca a cada tick.
	}
}