package mekanism.common.util;

import gregtech.client.renderer.IRenderSetup;
import gregtech.client.utils.EffectRenderContext;
import gregtech.client.utils.IBloomEffect;
import mekanism.api.util.time.Timeticks;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.tile.prefab.TileEntityBasicBlock;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public abstract class BloomEffect<T extends TileEntityBasicBlock> implements IBloomEffect, IRenderSetup {

    public T tile;
    public int north;
    public int south;
    public int west;
    public int east;

    public BloomEffect(T tile, int north, int south, int west, int east) {
        this.tile = tile;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    @Override
    public void preDraw(@NotNull final BufferBuilder bufferBuilder) {

    }

    @Override
    public void postDraw(@NotNull final BufferBuilder bufferBuilder) {

    }

    @Override
    public void renderBloomEffect(@NotNull final BufferBuilder bufferBuilder, @NotNull final EffectRenderContext effectRenderContext) {
        if (tile != null) {
            GlStateManager.pushMatrix();
            BlockPos pos = tile.getPos();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            double cX = effectRenderContext.cameraX();
            double cY = effectRenderContext.cameraY();
            double cZ = effectRenderContext.cameraZ();
            GlStateManager.translate((x + 0.5F) - cX, (y + 1.5F) - cY, (z + 0.5F) - cZ);
            MekanismRenderer.rotate(tile.facing, north, south, west, east);
            GlStateManager.rotate(180, 0, 0, 1);
            RenderModelBloom();
            GlStateManager.popMatrix();
        }
    }

    protected abstract void RenderModelBloom();

}
