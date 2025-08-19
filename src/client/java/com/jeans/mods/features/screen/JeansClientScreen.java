package com.jeans.mods.features.screen;


import com.jeans.mods.features.fishing.AutoFishing;
import com.jeans.mods.features.fishing.RodInteractor;
import com.jeans.mods.features.flying.Flying;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class JeansClientScreen extends Screen {
    private final Screen parent;

    public JeansClientScreen(Screen parent) {
        super(Text.literal("Jean's Client Mod!")); // Titulo da tela
        this.parent = parent; //Recebe a tela anterior como "mãe" para ser devolvida depois.
    }

    @Override
    protected void init() {
        int centerX = this.width/2;
        int centerY = this.height/2;

        // Precisa ioncluir feedback do botão com o status ligado/desligado do feature.

        // Primeiro botão da tela:
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Auto Fishing"), button -> {
            RodInteractor.togleAutoFishing();
        }).dimensions(centerX - 100, centerY - 30, 200, 20).build());

        // Segundo botão da tela:
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Flying"), button -> {
            Flying.togleFlying();
        }).dimensions(centerX - 100, centerY, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> {
            assert this.client != null;
            this.client.setScreen(parent);
        }).dimensions(centerX - 100, centerY + 30, 200, 20).build());

        // Cada botão está no meio do eixo X e deslogado 30 pixels entre eles. Verificar o espacamento depois.
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta); // Necessário para desenhar o que está programado no init
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
    }
}
