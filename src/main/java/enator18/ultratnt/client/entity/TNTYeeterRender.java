package enator18.ultratnt.client.entity;

import enator18.ultratnt.UltraTNT;
import enator18.ultratnt.client.entity.model.TNTYeeterModel;
import enator18.ultratnt.entity.TNTYeeterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TNTYeeterRender extends MobRenderer<TNTYeeterEntity, TNTYeeterModel<TNTYeeterEntity>>
{
protected static final ResourceLocation TEXTURE = new ResourceLocation(UltraTNT.MODID,"textures/entity/tnt_yeeter.png");
	
	public TNTYeeterRender(EntityRendererManager renderManagerIn)
	{
		super(renderManagerIn, new TNTYeeterModel<TNTYeeterEntity>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(TNTYeeterEntity entity)
	{
		return TEXTURE;
	}
}
