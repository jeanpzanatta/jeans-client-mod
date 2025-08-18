package com.jeans.mods.features;

import net.fabricmc.api.ClientModInitializer;

public class JeansInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TickManager.init();
    }
}
