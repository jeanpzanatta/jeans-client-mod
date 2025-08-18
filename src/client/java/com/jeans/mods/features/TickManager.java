package com.jeans.mods.features;

import com.jeans.mods.features.flying.Flying;
import com.jeans.mods.features.fishing.AutoFishing;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class TickManager {
    private static final List<TickableFeature> FEATURES = new ArrayList<>();

    public static void registerFeatures() {
        FEATURES.add(new AutoFishing());
        FEATURES.add(new Flying());
        // adicionar novas features aqui
    }

    public static void init() {
        registerFeatures();
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (TickableFeature feature : FEATURES) {
                feature.tick(client);
            }
        });
    }
}
