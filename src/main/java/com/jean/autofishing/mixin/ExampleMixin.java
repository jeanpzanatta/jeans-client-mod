package com.jean.autofishing.mixin;

import com.jean.autofishing.AutoFishing;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


/*
Mixin para sobrescrever "onTrackedDataSet" usado em "FishingBobberEntity",
o métod é chamado quando o peixe é fisgado, não em tod tick.
 */
@Mixin(FishingBobberEntity.class)
public abstract class ExampleMixin {
	@Shadow private boolean caughtFish;

	@Inject(at = @At("TAIL"), method = "onTrackedDataSet")
	public void onTrackedDataSet(TrackedData<?> data, CallbackInfo info){
        AutoFishing.LOGGER.info("Fisgado: {}", caughtFish);

	}
}