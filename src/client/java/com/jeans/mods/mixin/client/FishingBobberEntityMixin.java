package com.jeans.mods.mixin.client;


import com.jeans.mods.features.fishing.RodInteractor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


/*
Mixin para sobrescrever "onTrackedDataSet" usado em "FishingBobberEntity",
o métod é chamado quando o peixe é fisgado, não em tod tick.
*/
@Mixin(net.minecraft.entity.projectile.FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin {
	@Shadow private boolean caughtFish;

	@Inject(at = @At("TAIL"), method = "onTrackedDataSet")
	public void onTrackedDataSet(TrackedData<?> data, CallbackInfo info){
		if(caughtFish){
			MinecraftClient client = MinecraftClient.getInstance();
			RodInteractor.castRod(client);
			RodInteractor.castScheduler(20);
		}
	}
}