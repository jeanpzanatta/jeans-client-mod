package com.jeans.mods.features;

import net.minecraft.client.MinecraftClient;

public interface TickableFeature {
    void tick(MinecraftClient client);
}
