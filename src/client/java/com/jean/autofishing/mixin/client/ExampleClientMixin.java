package com.jean.autofishing.mixin.client;

import com.jean.autofishing.AutoFishing;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
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
public abstract class ExampleClientMixin {
	@Shadow private boolean caughtFish;

	@Inject(at = @At("TAIL"), method = "onTrackedDataSet")
	public void onTrackedDataSet(TrackedData<?> data, CallbackInfo info){
		AutoFishing.LOGGER.info("Fisgado: {}", caughtFish);

		MinecraftClient cliente = MinecraftClient.getInstance();

		if(caughtFish){
			try {
				assert cliente.interactionManager != null;
				cliente.interactionManager.interactItem(cliente.player, Hand.MAIN_HAND);
			} catch (NullPointerException e){
				AutoFishing.LOGGER.info("Não foi possível pegar o peixe automaticamente");
			}

		}
	}
}