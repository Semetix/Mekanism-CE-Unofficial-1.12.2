package mekanism.client.render.item.machine;

import javax.annotation.Nonnull;
import mekanism.client.model.ModelChemicalCrystallizer;
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
public class RenderChemicalCrystallizerItem {

    private static ModelChemicalCrystallizer chemicalCrystallizer = new ModelChemicalCrystallizer();

    public static void renderStack(@Nonnull ItemStack stack, TransformType transformType, MekanismRenderHelper renderHelper) {
        GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);
        renderHelper.translate(0.05F, -1.001F, 0.05F);
        MekanismRenderer.bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "ChemicalCrystallizer.png"));
        chemicalCrystallizer.render(0.0625F);
    }
}