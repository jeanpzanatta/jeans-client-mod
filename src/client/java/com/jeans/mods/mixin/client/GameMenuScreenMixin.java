package com.jeans.mods.mixin.client;

import com.jeans.mods.features.screen.JeansClientScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text text) {super(text);}

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci){
        this.addDrawableChild(ButtonWidget.builder(Text.of("Jean's Mod"), (btn) -> this.client.setScreen(new JeansClientScreen(this))).dimensions(5, 5, 60, 20).build());

    }

}
