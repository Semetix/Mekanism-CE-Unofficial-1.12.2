package mekanism.client.render.tileentity;

import mekanism.api.util.time.Timeticks;
import mekanism.client.Utils.RenderTileEntityTime;
import mekanism.client.model.ModelDigitalMiner;
import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.MinerVisualRenderer;
import mekanism.common.tile.machine.TileEntityDigitalMiner;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDigitalMiner extends RenderTileEntityTime<TileEntityDigitalMiner> {

    private ModelDigitalMiner model = new ModelDigitalMiner();


    @Override
    public void render(TileEntityDigitalMiner tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "DigitalMiner.png"));

        MekanismRenderer.rotate(tileEntity.facing, 0, 180, 90, 270);
        GlStateManager.translate(0, 0, -1.0F);

        GlStateManager.rotate(180, 0, 0, 1);
        model.render(getTime(), 0.0625F, tileEntity.isActive, rendererDispatcher.renderEngine);
        GlStateManager.popMatrix();

        if (tileEntity.clientRendering) {
            MinerVisualRenderer.render(tileEntity);
        }
    }
    public ModelDigitalMiner getModel() {
        return model;
    }
}
