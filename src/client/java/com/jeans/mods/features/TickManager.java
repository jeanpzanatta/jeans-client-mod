package com.jeans.mods.features;

import com.jeans.mods.features.flying.Flying;
import com.jeans.mods.features.fishing.AutoFishing;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.ArrayList;
import java.util.List;

public class TickManager implements ClientModInitializer {

    // Inicia as modiciações do cliente já registrando todos as classes que usam ticks em sua lógica
    @Override
    public void onInitializeClient() {
        registerFeatures();
        // Todas as classes que implementam TickFeature são chamadas através dessa função a cada tick.
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (TickableFeature feature : FEATURES) {
                feature.tick(client);
            }
        });
    }
    private static final List<TickableFeature> FEATURES = new ArrayList<>();

    public static void registerFeatures() {
        FEATURES.add(new AutoFishing());
        FEATURES.add(new Flying());
        // adicionar novas features aqui
    }
}
