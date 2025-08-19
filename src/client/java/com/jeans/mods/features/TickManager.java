package com.jeans.mods.features;

import com.jeans.mods.features.flying.Flying;
import com.jeans.mods.features.fishing.AutoFishing;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class TickManager implements ClientModInitializer {

    // Inicia as modiciações do cliente já registrando todos as classes que usam ticks em sua lógica
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::callTicks);
        }

    private void callTicks(MinecraftClient client) {
        Flying.tick(client);
        AutoFishing.tick(client);
    }
}
