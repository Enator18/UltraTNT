package enator18.ultratnt.client.entity;

import enator18.ultratnt.UltraTNT;
import enator18.ultratnt.client.entity.model.TestEntityModel;
import enator18.ultratnt.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TestEntityRender extends MobRenderer<TestEntity, TestEntityModel<TestEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UltraTNT.MODID,"textures/entity/test_entity.png");
	
	public TestEntityRender(EntityRendererManager renderManagerIn)
	{
		super(renderManagerIn, new TestEntityModel<TestEntity>(), 0.8f);
	}

	@Override
	public ResourceLocation getEntityTexture(TestEntity entity)
	{
		return TEXTURE;
	}
	
	
}
