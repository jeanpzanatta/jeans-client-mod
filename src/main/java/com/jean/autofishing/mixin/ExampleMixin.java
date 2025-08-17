package com.jean.autofishing.mixin;

import com.jean.autofishing.AutoFishing;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


/*
Mixin para sobrescrever "tick" usado em "FishingBobberEntity",
pois a cada tick o jogo verifica se a isca foi fisgada e retorna
um boolean. Usado apenas para teste, o console deve retornar true ou false.
 */
@Mixin(FishingBobberEntity.class)
public class ExampleMixin {
	@Shadow private boolean caughtFish;

	@Inject(at = @At("TAIL"), method = "tick()V")
	public void tick(CallbackInfo info){
        AutoFishing.LOGGER.info("Fisgado: {}", caughtFish);
	}
}