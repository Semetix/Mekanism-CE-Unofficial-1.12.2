package mekanism.multiblockmachine.client.render.machine;

import mekanism.api.util.time.Timeticks;
import mekanism.client.render.MekanismRenderer;
import mekanism.multiblockmachine.client.model.machine.ModelLargeElectrolyticSeparator;
import mekanism.multiblockmachine.common.tile.machine.TileEntityLargeElectrolyticSeparator;
import mekanism.multiblockmachine.common.util.MekanismMultiblockMachineUtils;
import net.minecraft.client.renderer.GlStateManager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLargeElectrolyticSeparator extends TileEntitySpecialRenderer<TileEntityLargeElectrolyticSeparator> {

    private ModelLargeElectrolyticSeparator model = new ModelLargeElectrolyticSeparator();
    private Timeticks time = new Timeticks(20, 20, false);

    @Override
    public void render(TileEntityLargeElectrolyticSeparator tileEntity, double x, double y, double z, float partialTick, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        bindTexture(MekanismMultiblockMachineUtils.getResource(MekanismMultiblockMachineUtils.ResourceType.RENDER_MACHINE,"ElectrolyticSeparator/ElectrolyticSeparator.png"));
        MekanismRenderer.rotate(tileEntity.facing, 0, 180, 90, 270);
        GlStateManager.rotate(180, 0, 0, 1);
        double tick = time.getValue() / 20F;
        model.render(tick, 0.0625F, tileEntity.getActive(), rendererDispatcher.renderEngine,tileEntity.getScaledFluidTankLevel(),tileEntity.getScaledLeftTankGasLevel(),tileEntity.getScaledRightTankGasLevel());
        GlStateManager.popMatrix();
    }
}