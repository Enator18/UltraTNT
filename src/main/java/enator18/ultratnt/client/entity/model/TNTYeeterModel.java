package enator18.ultratnt.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import enator18.ultratnt.entity.TNTYeeterEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class TNTYeeterModel<T extends TNTYeeterEntity> extends EntityModel<T>
{
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer tnt;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer head;

	public TNTYeeterModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(40, 40).addBox(-4.0F, -16.0F, -6.0F, 8.0F, 12.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(0, 32).addBox(-4.0F, -28.0F, -6.0F, 8.0F, 12.0F, 12.0F, 0.0F, false);
		
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -23.0F, -6.0F);
		body.addChild(head);
		head.setTextureOffset(48, 0).addBox(-4.0F, -5.0F, -8.01F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, -22.0F, 0.0F);
		body.addChild(arms);
		arms.setTextureOffset(28, 32).addBox(-6.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		arms.setTextureOffset(0, 32).addBox(-6.0F, -10.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		arms.setTextureOffset(40, 40).addBox(4.0F, -10.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		arms.setTextureOffset(0, 0).addBox(4.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);

		tnt = new ModelRenderer(this);
		tnt.setRotationPoint(-5.0F, 22.0F, -1.0F);
		arms.addChild(tnt);
		tnt.setTextureOffset(0, 0).addBox(-3.0F, -48.0F, -7.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-5.0F, -10.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.setTextureOffset(16, 56).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		rightLeg.setTextureOffset(60, 28).addBox(-1.0F, 3.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(5.0F, -10.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.setTextureOffset(32, 60).addBox(-1.0F, 3.0F, -2.0F, 2.0F, 7.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 56).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
	}
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	    this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	    this.arms.rotateAngleX = entityIn.getArmRotation();
	    this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	    this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	}
}
