package enator18.ultratnt.client.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import enator18.ultratnt.entity.PrimedTNTBaseEntity;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TNTMinecartRenderer;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PrimedTNTBaseRender extends EntityRenderer<PrimedTNTBaseEntity>
{
	public PrimedTNTBaseRender(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn);
	      this.shadowSize = 0.5F;
	   }

	   public void render(PrimedTNTBaseEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
	   {
		   matrixStackIn.push();
		   matrixStackIn.translate(0.0D, 0.5D, 0.0D);
		   if ((float)entityIn.getFuse() - partialTicks + 1.0F < 10.0F)
		   {
			   float f = 1.0F - ((float)entityIn.getFuse() - partialTicks + 1.0F) / 10.0F;
			   f = MathHelper.clamp(f, 0.0F, 1.0F);
			   f = f * f;
			   f = f * f;
			   float f1 = 1.0F + f * 0.3F;
			   matrixStackIn.scale(f1, f1, f1);
		   } 
		  
		   matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90.0F));
		   matrixStackIn.translate(-0.5D, -0.5D, 0.5D);
		   matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
		   TNTMinecartRenderer.renderTntFlash(Blocks.TNT.getDefaultState(), matrixStackIn, bufferIn, packedLightIn, entityIn.getFuse() / 5 % 2 == 0);
		   matrixStackIn.pop();
		   super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	   }

	   /**
	    * Returns the location of an entity's texture.
	    */
	   @SuppressWarnings("deprecation")
	public ResourceLocation getEntityTexture(PrimedTNTBaseEntity entity) {
	      return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
	   }
}
