package mekanism.client.render.item.machine;

import javax.annotation.Nonnull;
import mekanism.client.model.ModelSeismicVibrator;
import mekanism.client.render.MekanismRenderHelper;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSeismicVibratorItem {

    private static ModelSeismicVibrator seismicVibrator = new ModelSeismicVibrator();

    public static void renderStack(@Nonnull ItemStack stack, TransformType transformType, MekanismRenderHelper renderHelper) {
        GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);
        renderHelper.scale(0.6F).translateY(-0.55F);
        MekanismRenderer.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "SeismicVibrator.png"));
        seismicVibrator.render(0.0625F);
    }
}