package com.jeans.mods.features.flying;

import com.jeans.mods.features.TickableFeature;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class Flying  implements TickableFeature {
    private static boolean isFlyingEnable = true;

    @Override
    public void tick(MinecraftClient client){
        if(client.player != null && client.player.hasVehicle() && isFlyingEnable){
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = client.options.jumpKey.isPressed() ? 0.5 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }
    }

    public static void toggleFlying(){
        isFlyingEnable = !isFlyingEnable;
    }
}
